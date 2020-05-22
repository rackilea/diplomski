signingConfigs {
    debug {
        storeFile file("debug.jks")
        storePassword ...
        keyAlias ...
        keyPassword ...
    }
}

buildTypes {
    debug {
        signingConfig signingConfigs.debug
    }
    release {
        ...
    }
}