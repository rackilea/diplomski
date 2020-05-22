buildscript {
    repositories {
        mavenCentral()
   }

if (gradle.gradleVersion >= "2.2") {
    dependencies {
        classpath 'com.android.tools.build:gradle:1.0.0+'
    }
} else if (gradle.gradleVersion >= "2.1") {
    dependencies {
        classpath 'com.android.tools.build:gradle:0.14.0+'
    }
} else {
    dependencies {
        classpath 'com.android.tools.build:gradle:0.12.0+'
        compile 'com.android.support:support-v4:13.0+'
    }
}
 }