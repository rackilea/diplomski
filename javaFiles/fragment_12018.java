android {
    compileSdkVersion 26
    buildToolsVersion "26.0.1"

    defaultConfig {
        ...        
        //jackOptions { // DEPRECATED
            //enabled true
        //}
    }
    dexOptions {
        incremental true
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}