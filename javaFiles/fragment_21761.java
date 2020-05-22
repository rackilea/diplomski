apply plugin: "java"
apply plugin: "war"

archivesBaseName = "subprojectA"

sourceCompatibility = 1.8
compileJava.options.encoding = "utf-8"

war {
    manifest {
        archiveName = "$baseName.$extension"
        attributes "Implementation-Title": archivesBaseName, 
                   "Implementation-Version": version
    }
}

// declare configuration to refer to in superprojectB
configurations {
    subprojectAwar
}
// make this configuration deliver the generated war
dependencies {
    subprojectAwar files(war.archivePath)
}