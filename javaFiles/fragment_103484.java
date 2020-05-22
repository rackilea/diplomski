sourceSets {
    test {
        java.srcDirs = ['src/test/java']
    }
    integration {
        java.srcDirs = ['src/integration/java']
        resources.srcDir 'src/integration/resources'
        compileClasspath += main.output + test.output
        runtimeClasspath += main.output + test.output
    }
}

configurations {
    integrationCompile.extendsFrom testCompile
    integrationRuntime.extendsFrom testRuntime
}

task integration(type: Test, group: 'Verification') {
    testClassesDir = sourceSets.integration.output.classesDir
    classpath = sourceSets.integration.runtimeClasspath
}