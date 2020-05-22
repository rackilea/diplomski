buildscript {
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}



apply plugin: 'com.neenbedankt.android-apt'

dependencies {
    compile 'org.greenrobot:eventbus:3.0.0'
    apt 'org.greenrobot:eventbus-annotation-processor:3.0.1'
}

apt {
    arguments {
        eventBusIndex "com.example.myapp.MyEventBusIndex"
    }
}