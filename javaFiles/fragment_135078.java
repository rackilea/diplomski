android {
    buildTypes {
        release {
             buildConfigField "String", "API_URL", "\"api.example.com\""
        }

        debug {
             buildConfigField "String", "API_URL", "\"debug-api.example.com\""
        }
    }
}