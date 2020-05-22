jar {
  manifest {
  attributes 'Implementation-Version': version,
             'Main-Class': mainClass
  }
  from {configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }}
}