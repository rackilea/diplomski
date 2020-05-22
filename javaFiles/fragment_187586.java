sourceSets {
      main {
        compileClasspath += configurations.compileOnly
      }
      test {
        compileClasspath += configurations.compileOnly
      }
    }