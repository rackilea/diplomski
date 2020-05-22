task dist << {
   project.copy {
      from configurations.compile
      into file('distribution/lib')
   }
}
jar.finalizedBy(dist)