repositories {
    jcenter()
    maven {
        url "http://repo.maven.apache.org/maven2"
    }
}

dependencies {
   ...
   testCompile group: 'io.appium', name: 'java-client', version: requiredVersion {
       exclude module: 'selenium-java'
   }
   
   testCompile group: 'org.seleniumhq.selenium', name: 'selenium-java', 
   version: requiredSeleniumVersion
   ...
}