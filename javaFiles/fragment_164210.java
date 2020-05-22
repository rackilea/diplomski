task testJar(type: Jar) {
    from sourceSets.test.output
    version = System.getProperty('RELEASE_VERSION', "unversioned")
    appendix="test"
}
jar {
    version = System.getProperty('RELEASE_VERSION', "unversioned")
}