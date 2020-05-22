apply plugin: 'java'

compileJava.options.encoding = 'UTF-8'

tasks.withType(Test) {
    systemProperties = System.getProperties()
    systemProperties.remove("java.endorsed.dirs")
}

task runBinaryTests(type: Test) {
    testClassesDirs = project.files( "$projectDir/unzipped", configurations.runtime )
    classpath = project.files( "$projectDir/fatjar.jar", configurations.runtime )
    outputs.upToDateWhen { false }
}