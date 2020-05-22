apply plugin: 'java-library'
dependencies {
  implementation 'org.springframework:spring-web:5.2.1.RELEASE'
}
task dumpDependencies {
  doLast {
    def resolved = configurations.compileClasspath.resolvedConfiguration
    println "files=$resolved.files"
    resolved.resolvedArtifacts.each {
      artifact-> println "artifact=$artifact"
    }
  }
}