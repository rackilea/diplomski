tasks.withType(JavaCompile) {
  options.annotationProcessorGeneratedSourcesDirectory = file("src/generated/java")
}


sourceSets {
    generated {
        java {
            srcDirs = ['src/generated/java']
        }
    }
}