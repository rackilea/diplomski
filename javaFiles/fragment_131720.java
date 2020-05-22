if (!(project.hasProperty('env') && project.getProperty('env') == 'dev')) {
sourceSets {
    main {
        java {
//            exclude '**/Server*'
            exclude '**/MariaDB4j*'
            exclude '**/ServerWithMariaDB4jApplication.java'
//            exclude '**/EmbeddedTomcatWithSSLConfiguration.java'
        }
    }
    test {
        java {
            exclude '**/core/boot/tests/**'
        }
    }
}
}