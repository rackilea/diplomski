plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.6'
}

compileJava {
    exclude 'module-info.java'

    options.compilerArgs = ['--release', '8']
}

task compileModuleInfoJava(type: JavaCompile) {
    classpath = files() // empty
    source = 'src/main/java/module-info.java'
    destinationDir = compileJava.destinationDir // same dir to see classes compiled by compileJava

    doFirst {
        options.compilerArgs = [
                '--release', '9',
                '--module-path', compileJava.classpath.asPath,
        ]
    }
}

compileModuleInfoJava.dependsOn compileJava
classes.dependsOn compileModuleInfoJava