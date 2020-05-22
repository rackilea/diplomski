apply plugin: 'distribution'

plugins.withType(DistributionPlugin) {
    distTar {
        compression = Compression.GZIP
        extension = 'tar.gz'
    }
}

configurations {
    wholeProjectDist
}

dependencies {
    wholeProjectDist project(path: ':3pp-a-module', configuration: 'archives')
    wholeProjectDist project(path: ':3pp-b-module', configuration: 'archives')
    wholeProjectDist project(':lib-java-module')
    wholeProjectDist project(':spring-boot-module')
}

distributions {
    main {
        contents {
            from configurations.wholeProjectDist
        }
    }
}