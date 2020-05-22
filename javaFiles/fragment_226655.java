...
android {
    ...
    defaultConfig { ... }
    signingConfigs { ... }
    buildTypes { ... }
    productFlavors {
        demo {
            applicationId "com.buildsystemexample.app.demo"
            versionName "1.0-demo"
        }
        full {
            applicationId "com.buildsystemexample.app.full"
            versionName "1.0-full"
        }
    }
}
...