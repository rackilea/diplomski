sourceSets {
  integrationTest {
    java {
      compileClasspath += main.output + test.output
      runtimeClasspath += main.output + test.output
      srcDir file('src/integrationTest/java')
    }
    resources.srcDir file('src/integrationTest/resources')
  }
}