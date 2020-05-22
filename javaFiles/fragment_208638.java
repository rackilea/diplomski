preBuild.doFirst {
    android.applicationVariants.all { variant ->
        variant.productFlavors.each { flavor ->
            if (variant.buildType.name.equals('release')) {
                javaexec {
                    println "Triggering customer build for flavor " + flavor.name
                    classpath += files("libs/my-jarfile.jar")
                    main = "de.myapp.gradle.ConfigureCustomer"
                    args flavor.name, variant.versionName
                }
                println "Done building customer for flavor " + flavor.name
            }
        }
    }
}