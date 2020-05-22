publishing {
    publications {
      dist(MavenPublication) {
        mode = "dist"
        alias false
        from components.java
        afterEvaluate {
          artifact apiJar
        }
      }
      bundle(MavenPublication) {
        mode = "lib"
        alias true
        from components.java
        afterEvaluate {
          artifactId "${artifactId}-bundle"
        }
      }
    }
    repositories {...}
  }