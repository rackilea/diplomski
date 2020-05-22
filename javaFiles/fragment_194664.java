// these are your protobuf plugin repositories
buildscript {  
   repositories {
       maven {
           url 'WHERE YOUR PROTOBUF PLUGIN EXISTS. e.g. http://maven or MavenCentral()'
       } 
   }

   dependencies {
       classpath 'com.google.protobuf:protobuf-gradle-plugin:0.7.0'    
       classpath 'com.google.protobuf:protoc:2.6.1'
   }
}

apply plugin: 'com.google.protobuf'

group = "YOUR PACKAGE NAME. e.g. com.x.y"
version = "1.0" // release version

// these are your regular dependencies repositories. This could be
// very similar to the ones in buildscript above. 
repositories {  
    mavenLocal()
}

// this is needed by the plugin and is where teh magic happens. It 
// tells protobuf where to extract all the proto files that it finds 
// in all  the dependency jar files you have          
protobuf { 
    generatedFilesBaseDir="$projectDir/src/"    
}
// also magic you need for this protobuf plugin to work    
sourceSets {
     main {
        // this tells the plugin where your project specific
        // protofiles are located   
        proto {    
           srcDir 'src/main/resources/proto/'    
        }

        java {
           srcDir 'src/main/java'
         }
    }
}

dependencies {      
     compile 'com.google.protobuf:protobuf-java:2.6.1'
}