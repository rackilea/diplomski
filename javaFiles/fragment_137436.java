task fatjar << {
    jar.doFirst {
       println "creating fatjar"
       jar {
         from {configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }}
       }
    }
}