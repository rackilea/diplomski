sourceSets {
    main {
        resources {
            srcDir file('src/main/resources')
            include '**/*.sql'
            exclude '**/*.java'
        }
    }
}