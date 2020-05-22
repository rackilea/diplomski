sourceSets {
    main {
        java.srcDirs = ['src/main/java']
    }
    robolectric {
        java.srcDir file('src/test/java/')
        resources.srcDir file('src/test/resources')
    }
}