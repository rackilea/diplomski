defaultConfig {
    versionCode cdvVersionCode ?: new BigInteger("" + privateHelpers.extractIntFromManifest("versionCode"))
    applicationId privateHelpers.extractStringFromManifest("package")

    if (cdvMinSdkVersion != null) {
        minSdkVersion cdvMinSdkVersion
    }

    multiDexEnabled true
}