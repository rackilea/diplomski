task testIntegration(type: JavaExec, dependsOn: jar) {
    group 'Verification'
    description 'Runs the integration tests.'

    dependencies {
        testRuntime lib.junit5_console
    }

    classpath = sourceSets.testInt.runtimeClasspath
    systemProperties['jar.path'] = jar.archivePath

    main 'org.junit.platform.console.ConsoleLauncher'
    args = ['--scan-classpath', sourceSets.testInt.output.classesDirs.asPath,
            '--reports-dir', "${buildDir}/test-results/testInt"
    ]
}