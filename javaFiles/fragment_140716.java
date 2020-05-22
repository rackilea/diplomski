buildscript {
    dependencies {
        classpath 'com.h2database:h2:1.4.191'
    }
}

plugins {
    id "org.flywaydb.flyway" version "4.1.2"
}

flyway {
    url = 'jdbc:h2:file:./target/foobar'
    user = 'sa'
}

defaultTasks 'flywayMigrate'