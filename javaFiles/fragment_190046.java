buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        ...
    }
}

repositories {
    ...
}

// You need to add the google maven in this block.
allprojects {
    repositories {
        jcenter()
        google()
    }
}