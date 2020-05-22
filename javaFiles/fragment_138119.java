apply plugin: 'com.android.library'    
    android {
        compileSdkVersion 21
        buildToolsVersion "21.1.2"

        defaultConfig {
            minSdkVersion 14
            targetSdkVersion 21
            versionCode 1
            versionName "1.0"
        }
        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            }
        }
        packagingOptions {
            exclude 'META-INF/DEPENDENCIES'
            exclude 'META-INF/NOTICE'
            exclude 'META-INF/LICENSE'
            exclude 'META-INF/LICENSE.txt'
            exclude 'META-INF/NOTICE.txt'
        }
    }
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile 'com.android.support:appcompat-v7:+'
    compile 'com.google.android.gms:play-services:6.5.87'
    compile 'com.squareup.picasso:picasso:2.5.2'
    compile 'com.mcxiaoke.volley:library:1.0.15'
    compile 'com.google.code.gson:gson:2.2.4'
    compile "org.apache.httpcomponents:httpcore:4.4.1"
    compile "org.apache.httpcomponents:httpmime:4.3.6"


}