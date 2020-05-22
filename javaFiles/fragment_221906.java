android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion
    defaultConfig {
        // ...
        android.compileOptions.sourceCompatibility 1.8
        android.compileOptions.targetCompatibility 1.8
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ targetModuleName : 'Ship' ]
            }
        }

    }
}