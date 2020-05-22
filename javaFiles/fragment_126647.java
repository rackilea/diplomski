subprojects {
    apply plugin: 'java-library'
    sourceCompatibility = '1.8'
    targetCompatibility = '1.8'

    tasks.jar.dependsOn("clean")
}