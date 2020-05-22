buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.2.70"))   
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.70")
        classpath("com.github.ben-manes:gradle-versions-plugin:0.20.0")
    }
}