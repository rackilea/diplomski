android {
        // 1. USER EXAMPLE How to add debug.keystore in gradle
        // Default debug.keystore settings
    signingConfigs {
        config {
            keyAlias 'androiddebugkey'
            keyPassword 'android'
            storeFile file('C:/Users/USER/.android/debug.keystore')
            storePassword 'android'
        }
    }


 buildTypes {
        }
        debug {
            // 2. USER EXAMPLE How to add debug.keystore in gradle
              signingConfig signingConfigs.config
        }