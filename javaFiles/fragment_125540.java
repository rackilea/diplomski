repositories {
    flatDir {
        dirs 'libs'
    }
}

dependencies {
    implementation(name: 'HERE-sdk', ext: 'aar')
    implementation 'com.android.support:appcompat-v7:27.1.1'
}