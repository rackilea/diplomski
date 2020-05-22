apply plugin: 'com.android.application'
apply plugin: 'android-apt'

String packageName = "mateuszklimek.aaexample"

android {
    compileSdkVersion 21
    buildToolsVersion "21.1.1"

    defaultConfig {
        applicationId packageName
        minSdkVersion 15
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"
    }
}

apt {
    arguments {
        androidManifestFile variant.processResources.manifestFile
        resourcePackageName packageName
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    apt "org.androidannotations:androidannotations:3.2"
    compile "org.androidannotations:androidannotations-api:3.2"
}