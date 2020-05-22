sourceSets {
    main {
        java {
            srcDirs = ['main/java']
        }
        resources {
            srcDirs = ['main/resources']
        }
    }
    test {
        java {
            srcDirs = ['test/java']
        }
        resources {
            srcDirs = ['test/resources']
        }
    }
}