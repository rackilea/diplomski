apply plugin: 'java'
apply plugin: 'maven'

group = 'de.dynamicfiles.projects.javafx.bundler'
version = '1.0.1-SNAPSHOT'

description = """"""

sourceCompatibility = 1.8
targetCompatibility = 1.8
tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
}

repositories {
    maven { url "http://repo.maven.apache.org/maven2" }
}

dependencies {
    compile files("${System.getenv('JAVA_HOME')}/lib/ant-javafx.jar")
}