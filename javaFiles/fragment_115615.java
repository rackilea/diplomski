buildTypes {
    debug {
        buildConfigField "boolean","IS_TEST_ENVIRONMENT","true"
        buildConfigField "boolean","SOME_OTHER_FIELD","false"
    }
    release {
        buildConfigField "boolean","IS_TEST_ENVIRONMENT","true"
        buildConfigField "boolean","SOME_OTHER_FIELD","true"
        runProguard true
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }

}