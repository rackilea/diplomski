android.applicationVariants.all { variant ->
    // get app_name field from defaultConfig
    def appName = variant.mergedFlavor.resValues.get('app_name').getValue()

    // concat new App name with each flavor's name
    appName = "${appName}"
    variant.productFlavors.each { flavor ->
        appName += " ${flavor.name}"
    }

    // optionally add buildType name
    appName += " ${variant.buildType.name}"

    // your requirement: if buildType == debug, add DEV to App name
    if(variant.buildType.name == "debug") {
        appName += " DEV"
    }

    // set new resVale
    variant.resValue 'string', 'app_name', appName
}