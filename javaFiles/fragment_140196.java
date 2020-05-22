android.applicationVariants.all { variant ->
    variant.outputs.all { output ->
        output.processManifest.doLast {

            String manifestPath = "$manifestOutputDirectory/AndroidManifest.xml"
            def manifestContent = file(manifestPath).getText()

            // Manipulate the file as needed
        }
    }
}