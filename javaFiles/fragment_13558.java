buildTypes {
    debug {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        buildConfigField "String", "API_URL", "[apiURL]"
        buildConfigField "Boolean", "DEBUG_MODE", "true"
    }
    release {
        minifyEnabled true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        buildConfigField "String", "API_URL", "[apiURL]"
        buildConfigField "Boolean", "DEBUG_MODE", "false"
        signingConfig signingConfigs.config
    }