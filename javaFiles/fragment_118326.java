`task copyLibs(type: Copy) {
    from configurations.testRuntime.files
    into "$buildDir/lib"
}
task testJar(type: Jar, dependsOn: testClasses) {
    classifier = 'tests'
    from sourceSets.test.output
}`