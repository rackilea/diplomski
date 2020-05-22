apply plugin: 'java'

task compileOne (type: JavaCompile) {
    source = sourceSets.main.java.srcDirs
    include 'some/pkg/ClassTwo.java'
    classpath = sourceSets.main.compileClasspath
    destinationDir = sourceSets.main.output.classesDir
}

compileOne.options.compilerArgs = ["-sourcepath", "$projectDir/src/main/java"]