android {
    ...
    sourceSets {
        main {
            jniLibs.srcDirs 'imported-lib/src/', 'more-imported-libs/src/'
        }
    }
}