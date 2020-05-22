subprojects {
    apply plugin: 'java'
}

// Must be BELOW subprojects{}
task alljavadoc(type: Javadoc) {
    source subprojects.collect { it.sourceSets.main.allJava }
    classpath = files(subprojects.collect { it.sourceSets.main.compileClasspath })
    destinationDir = file("${buildDir}/docs/javadoc")
}

task javadocJar(type: Jar, dependsOn: alljavadoc) {
    classifier = 'javadoc'
    from alljavadoc.destinationDir
}

task sourcesJar(type: Jar) {
    classifier = 'sources'
    from subprojects.collect { it.sourceSets.main.allSource }
}

shadowJar.finalizedBy javadocJar
shadowJar.finalizedBy sourcesJar