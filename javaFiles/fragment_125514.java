android {
    buildTypes {
        debug {
            buildConfigField "int", "FOO", "42"
            buildConfigField "String", "FOO_STRING", "\"foo\""
            buildConfigField "boolean", "LOG", "true"
        }

        release {
            buildConfigField "int", "FOO", "52"
            buildConfigField "String", "FOO_STRING", "\"bar\""
            buildConfigField "boolean", "LOG", "false"
        }
    }
}