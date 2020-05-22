buildTypes {
    debug {
        debuggable true
        minifyEnabled false
    }
    release {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}