android {
compileSdkVersion 23
buildToolsVersion "23.0.1"
useLibrary 'org.apache.http.legacy'      // <---------------------

defaultConfig {
    applicationId "your application id"
    minSdkVersion 18
    targetSdkVersion 22
    versionCode 1
    versionName "1.0"
    multiDexEnabled true
}

packagingOptions {
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE.txt'
    exclude 'META-INF/DEPENDENCIES.txt'
    exclude 'META-INF/DEPENDENCIES'
    exclude 'META-INF/dependencies.txt'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/license.txt'
    exclude 'META-INF/LGPL2.1'
    exclude 'META-INF/NOTICE.txt'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/notice.txt'
}

buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}}

dependencies {
compile fileTree(include: ['*.jar'], dir: 'libs')
testCompile 'junit:junit:4.12'
compile 'com.android.support:appcompat-v7:23.2.1'
compile 'com.android.support:design:23.3.0
compile files('libs/ews-android-api.jar')    // <---------------------
compile 'joda-time:joda-time:2.8'}           // <---------------------