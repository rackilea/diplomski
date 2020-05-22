javaCompileOptions {
        annotationProcessorOptions {
            arguments = [
                    "androidManifestFile": "$projectDir/src/main/AndroidManifest.xml".toString()
            ]
        }
    }