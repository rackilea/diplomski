android {
    testOptions {
        unitTests {
            includeAndroidResources = true
        }
    }
}

dependencies {
    ...
    testCompile 'org.assertj:assertj-core:3.8.0'
    testImplementation "org.robolectric:robolectric:3.5.1"
    ...
}