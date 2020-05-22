android {
compileSdkVersion 23
buildToolsVersion "23.0.1"

defaultConfig {
    applicationId "com.androidbelieve.drawerwithswipetabs"
    minSdkVersion 15
    targetSdkVersion 23
}

buildTypes {
    release {
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
    }
}
}

dependencies {

compile 'com.android.support:appcompat-v7:23.2.1'
compile 'com.android.support:design:23.2.1'
compile 'com.android.support:recyclerview-v7:23.2.1'
compile 'com.android.support:support-v4:23.2.1'
compile 'com.android.support:cardview-v7:23.2.1'
}