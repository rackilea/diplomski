apply plugin: 'com.android.application'
apply plugin: 'com.google.gms.google-services'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "naik.dattaraj.meme2"
        minSdkVersion 22
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled true
    }
    packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/notice.txt'
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //AndroidX libraries
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.vectordrawable:vectordrawable:1.0.1'
    implementation 'androidx.gridlayout:gridlayout:1.0.0'
    implementation 'androidx.mediarouter:mediarouter:1.0.0'
    implementation 'androidx.palette:palette:1.0.0'
    implementation 'androidx.leanback:leanback:1.0.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.exifinterface:exifinterface:1.0.0'
    implementation 'androidx.annotation:annotation:1.0.1'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.legacy:legacy-support-v13:1.0.0'
    implementation 'androidx.test.espresso:espresso-core:3.1.1'
    testImplementation 'junit:junit:4.12'
    implementation 'com.google.android.material:material:1.0.0'
    //Navigation
    implementation 'androidx.navigation:navigation-fragment:2.0.0-rc02'
    implementation 'androidx.navigation:navigation-ui:2.0.0-rc02'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.0.0-rc02'
    implementation 'androidx.navigation:navigation-ui-ktx:2.0.0-rc02'
    implementation 'androidx.navigation:navigation-runtime:2.0.0-rc02'
    implementation 'androidx.test.espresso:espresso-contrib:3.1.1'
    implementation 'androidx.test:rules:1.1.1'
    //firebase
    implementation 'com.firebase:firebase-client-android:2.5.2'
    implementation 'com.google.firebase:firebase-database:18.0.0'
    implementation 'com.firebaseui:firebase-ui-database:2.1.0'
    implementation 'com.google.firebase:firebase-auth:18.1.0'
    implementation 'com.google.firebase:firebase-storage:18.1.0'
    //databinding
    implementation 'androidx.databinding:databinding-runtime:3.3.0'
    implementation 'androidx.databinding:databinding-common:3.3.0'
    implementation 'androidx.databinding:databinding-compiler:3.3.0'
    implementation 'com.android.databinding:adapters:3.3.0'
    implementation 'androidx.databinding:databinding-adapters:3.3.0'
    annotationProcessor 'androidx.databinding:databinding-compiler:3.3.0'
    //Google play services
    implementation 'com.google.android.gms:play-services:12.0.1'
    implementation 'com.google.android.gms:play-services-ads:17.1.2'
    implementation 'com.google.android.gms:play-services-wearable:16.0.1'
    implementation 'com.google.android.gms:play-services-maps:16.0.0'
    //Other libraries
    implementation 'com.shitij.goyal:slide-button:1.0.0'
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    implementation 'com.squareup.picasso:picasso:2.5.2'
    implementation 'de.hdodenhof:circleimageview:3.0.0'
    implementation 'com.rengwuxian.materialedittext:library:2.1.4'
    implementation 'com.github.shts:StoriesProgressView:3.0.0'
    implementation 'com.github.pwittchen:swipe-rx2:0.3.0'
    implementation 'com.tomer:fadingtextview:2.5'
    implementation 'com.andkulikov:transitionseverywhere:1.8.1'
    implementation 'com.theartofdev.edmodo:android-image-cropper:2.4.0'
    //compileOnly 'com.google.android.wearable:wearable:2.4.0'
    //implementation 'com.google.android.support:wearable:2.4.0'
}
apply plugin: 'com.google.gms.google-services'
com.google.gms.googleservices.GoogleServicesPlugin.config.disableVersionCheck = true