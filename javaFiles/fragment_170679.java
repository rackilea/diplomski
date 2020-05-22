configurations {
    provided
}

sourceSets {
    main { compileClasspath += configurations.provided }
}