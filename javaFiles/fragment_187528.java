android {
    defaultConfig {
        ...
        // enabling multidex
        multiDexEnabled true
    }
}

// add the dependencie
dependencies {
    compile 'com.android.support:multidex:1.0.0'
}