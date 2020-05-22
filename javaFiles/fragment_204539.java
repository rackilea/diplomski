buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.9.+'
        classpath 'com.github.dcendents:android-maven-plugin:1.0'
    }
}

apply plugin: 'android-library'
apply plugin: 'android-maven'

version '0.4.0'
group 'some.likely.group.name.goes.here'

repositories {
    mavenCentral()
}

dependencies {
    compile 'com.squareup.picasso:picasso:2.2.0'
    compile fileTree(dir: 'libs', include: '*.jar')
}

android {
  // as normal
}