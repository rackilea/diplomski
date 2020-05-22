task fatJar(type: Jar) {
  zip64 = true
  manifest {
    attributes 'Implementation-Title': 'Gradle Jar File Example',
            'Implementation-Version': 1.3,
            'Main-Class': 'org.example.AnIntegrationTest'
  }
  from sourceSets.test.output

  //collect all dependencies
  from { configurations.testRuntime.collect { it.isDirectory() ? it : zipTree(it) } }
  with jar
}