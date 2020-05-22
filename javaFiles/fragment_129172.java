jar  {
   duplicatesStrategy(DuplicatesStrategy.EXCLUDE)
   from { configurations.compile.collect { it.isDirectory() ? it : zipTree(it) } }
   manifest {
      attributes 'Main-Class': 'com.buddyware.treefrog.Main'
   }
}