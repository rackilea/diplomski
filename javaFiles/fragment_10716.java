buildTypes {
        debug {
            buildConfigField "String", "SERVER_URL", "\"http:TempRequest\""
        }
        release {
            buildConfigField "String", "SERVER_URL", "\"http:TempRequest\""
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }