apply plugin: "java"
apply plugin: 'application'

archivesBaseName = "subprojectB"

sourceCompatibility = 1.8
compileJava.options.encoding = "utf-8"

// declare configuration to take files from
configurations {
    subprojectAwar
}

dependencies {
    // bind the configuration to the respective configuration in subprojectA
    subprojectAwar project(path: ":subprojectA", configuration: "subprojectAwar")

    compile "org.apache.tomcat.embed:tomcat-embed-core:$tomcatEmbedVersion"
    compile "org.apache.tomcat.embed:tomcat-embed-websocket:$tomcatEmbedVersion"
    compile "org.apache.tomcat.embed:tomcat-embed-logging-log4j:$tomcatEmbedVersion"
    compile "org.apache.tomcat.embed:tomcat-embed-jasper:$tomcatEmbedVersion"
}

mainClassName = 'org.project.subprojectB.StartServer'

jar {
    // make sure this project is assembled after the war is generated
    dependsOn(":subprojectA:assemble")

    manifest {
        archiveName = "$baseName.$extension"
        attributes "Implementation-Title": archivesBaseName,
                   "Implementation-Version": version
        attributes 'Main-Class': '$mainClassName'
    }
    // if you need to copy the content of the war into the jar:
    // (otherwise only to the distribution, see below)
    /*
    from(zipTree(configurations.subprojectAwar.collect { it }[0])) {
        into ""
        exclude '**/META-INF/**'
    }
    */
}

// copy the content of the war excluding META-INF into the lib of superprojectB
applicationDistribution.from(zipTree(configurations.subprojectAwar.collect { it }[0])) {
     into "lib"
     exclude '**/META-INF/**'
}