sourceSets {
    integTest {
        java.srcDir file('src/integration-test/java')
        resources.srcDir file('src/integration-test/resources')
        compileClasspath = sourceSets.main.output + configurations.integTest
        runtimeClasspath = output + compileClasspath
    }
}