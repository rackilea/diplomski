configurations {
    desktopCompile
    androidCompile

    compileOnly.extendsFrom desktopCompile
    testCompile.extendsFrom desktopCompile // Assuming tests run on the desktop

    desktop {
        extendsFrom desktopCompile
        extendsFrom runtime
    }
    android {
        extendsFrom androidCompile
        extendsFrom runtime
    }
}

dependencies {
    androidCompile "some.android:dependency"
    desktopCompile "other.desktop:dependency"
}