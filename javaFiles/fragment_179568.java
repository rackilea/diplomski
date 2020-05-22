apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.wseemann.example"
        minSdkVersion 15
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    flavorDimensions "version"
    productFlavors {
        fat {
            ndk {
                abiFilters "armeabi", "armeabi-v7a", "x86", "mips", "x86_64", "arm64-v8a"
            }
        }

        armeabi {
            ndk {
                abiFilter "armeabi"
            }
        }

        armeabi_v7a {
            ndk {
                abiFilter "armeabi-v7a"
            }
        }

        x86 {
            ndk {
                abiFilter "x86"
            }
        }

        mips {
            ndk {
                abiFilter "mips"
            }
        }

        x86_64 {
            ndk {
                abiFilter "x86_64"
            }
        }

        arm64_v8a {
            ndk {
                abiFilter "arm64-v8a"
            }
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'com.android.support:appcompat-v7:28.0.0-rc01'
    implementation 'com.android.support.constraint:constraint-layout:1.1.2'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

    // Product flavor, ABI specific dependencies
    fatImplementation 'com.github.wseemann:FFmpegMediaMetadataRetriever:1.0.14'
    armeabiImplementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-armeabi:1.0.14'
    armeabi_v7aImplementation'com.github.wseemann:FFmpegMediaMetadataRetriever-armeabi-v7a:1.0.14'
    x86Implementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-x86:1.0.14'
    mipsImplementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-mips:1.0.14'
    x86_64Implementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-x86_64:1.0.14'
    arm64_v8aImplementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-arm64-v8a:1.0.14'
}