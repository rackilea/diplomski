jar {
   def manifestClasspath = configurations.compile.collect{ 'lib/' + it.getName() }.join(' ')
   manifest {
      attributes "Main-Class" : "com.hoge.TestMain"
      attributes 'Class-Path': manifestClasspath
   }
   from (configurations.compile.resolve().collect { it.isDirectory() ? it : fileTree(it) }) {
      exclude 'META-INF/MANIFEST.MF'
      exclude 'META-INF/*.SF'
      exclude 'META-INF/*.DSA'
      exclude 'META-INF/*.RSA'
   }
   destinationDir = file("distribution")
   archiveName = 'hoge.jar'
}