buildscript {
    repositories {
        google()
    }
    dependencies {
        def nav_version = "2.3.0-alpha01"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
}