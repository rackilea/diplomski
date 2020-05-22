apply plugin: 'java'

configurations {
    provided
}

sourceSets {
    main {
        compileClasspath += configurations.provided
    }
}

dependencies {
    provided 'com.google.guava:guava:18.0'
}