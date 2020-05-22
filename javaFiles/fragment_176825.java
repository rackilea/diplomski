apply plugin: 'java'

javadoc {
    source = sourceSets.main.allJava
    classpath = configurations.compile
}