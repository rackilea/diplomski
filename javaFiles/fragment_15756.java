task proguardFiles(type: ProGuardTask, dependsOn: compileJava) {
    printmapping "$buildDir/outputs/mapping/mapping.txt"
    configuration 'proguard-rules.pro'

    libraryjars files(configurations.compile.findAll {}.collect())

    injars sourceSets.main.output

    outjars "$buildDir/libs/myJarName-${version}.jar"
}