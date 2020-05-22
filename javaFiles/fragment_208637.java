android {
//Build type setup, signing configuration and other stuff
}

//After the android block my task definition follows:

task buildPrintout(type: JavaExec) {
    android.applicationVariants.all { variant ->
    //Runt he java task for every flavor
        variant.productFlavors.each { flavor ->
            println "Triggering customer configuration for flavor " + flavor.name
            if (variant.buildType.name.equals('release')) {
                //Run the java task only for release builds
                //Cant find the runtime classpath in android/gradle so I'll directly link to my jar file here. The jarfile contains the class I want to run (with the main method)
                classpath += files("libs/my-jarfile.jar")
                //This is the fully qualified name of my class, including package name (de.myapp.gradle) and the classname (ConfigureCustomer)
                main = "de.myapp.gradle.ConfigureCustomer"
                //Pass in arguments - in this case the customer's name and the version name for the app (from AndroidManifest.xml)
                args flavor.name, variant.versionName
            }
        }
    }
}