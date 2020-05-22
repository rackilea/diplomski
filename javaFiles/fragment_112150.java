buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.1.2'
        classpath fileTree(include: ['*.jar'], dir: 'app/libs')
        classpath files('app/libs/google-services-3.0.0.jar')

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}