apply plugin: 'distribution'

distributions {
  main {
   baseName = project.name
    contents {
      into('lib/') {  // Copy the following jars to the lib/ directory in the distribution archive
        from jar
        from configurations.runtimeClasspath
        dirMode = 0755
        fileMode = 0644
      }
      from('src/main/dist') {  // Contents of this directory are copied by default
        dirMode = 0755
        fileMode = 0644
      }
    }
  }
}