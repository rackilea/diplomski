android {
    compileSdkVersion 21
    buildToolsVersion "22.0.1"

    defaultConfig {
        applicationId "jreddit.github.com.jredditsampleproject"
        minSdkVersion 19
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
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_6
        targetCompatibility JavaVersion.VERSION_1_6
    }

    packagingOptions {
        exclude 'META-INF/DEPENDENCIES.txt'
        exclude 'META-INF/LICENSE.txt'
        exclude 'META-INF/NOTICE.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/notice.txt'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/dependencies.txt'
        exclude 'META-INF/LGPL2.1'
        exclude 'META-INF/plexus/components.xml'
    }
}

dependencies {
    compile('com.github.jreddit:jreddit:1.0.3') {
        exclude group: 'org.apache.httpcomponents', module: 'httpclient'
        exclude module: 'junit'
    }
    compile 'org.apache.httpcomponents:httpclient-android:4.3.5.1'
    compile 'com.android.support:appcompat-v7:22.0.0'
}