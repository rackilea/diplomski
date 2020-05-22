...

repositories {

    ...

    flatDir {
        dirs 'libs/compile', 'libs/compile/downloaded',
                'libs/testCompile', 'libs/testCompileDownloaded',
                'libs/androidTestCompile', 'libs/androidTestCompile/downloaded'
    }
}

configurations {
    download
    testDownload
    androidTestDownload
}

android {
    ...
}

dependencies {
    download(
            'com.android.support:support-v4:+',
            'com.android.support:appcompat-v7:+',
            'com.google.android.gms:play-services-location:+',
            'com.facebook.android:facebook-android-sdk:+',
            'com.vk:androidsdk:+',
            'com.crashlytics.sdk.android:crashlytics:+',
            'oauth.signpost:signpost-core:+',
            'oauth.signpost:signpost-commonshttp4:+',
            'org.twitter4j:twitter4j-core:+',
            'commons-io:commons-io:+',
            'com.google.code.gson:gson:+',
            'org.jdeferred:jdeferred-android-aar:+'
    )
    compile fileTree(dir: 'libs/compile', include: '**/*.jar')
    testCompile fileTree(dir: 'libs/testCompile', include: '**/*.jar')
    androidTestCompile fileTree(dir: 'libs/androidTestCompile', include: '**/*.jar')
}


task cleanDownloadedDependencies(type: Delete) {
    delete fileTree('libs/compile/downloaded')
}

task cleanDownloadedTestDependencies(type: Delete) {
    delete fileTree('libs/testCompile/downloaded')
}

task cleanDownloadedAndroidTestDependencies(type: Delete) {
    delete fileTree('libs/androidTestCompile/downloaded')
}

task downloadDependencies(type: Copy) {
    from configurations.download
    into 'libs/compile/downloaded/'
}

task downloadTestDependencies(type: Copy) {
    from configurations.testDownload
    into 'libs/testCompile/downloaded/'
}

task downloadAndroidTestDependencies(type: Copy) {
    from configurations.androidTestDownload
    into 'libs/androidTestCompile/downloaded/'
}

task updateDependencies {
    dependsOn cleanDownloadedDependencies, cleanDownloadedTestDependencies, cleanDownloadedAndroidTestDependencies, downloadDependencies, downloadTestDependencies, downloadAndroidTestDependencies
}

fileTree(dir: 'libs/compile', include: '**/*.aar')
        .each { File file ->
    dependencies.add("compile",
            [name: file.name.lastIndexOf('.').with { it != -1 ? file.name[0..<it] : file.name }, ext: 'aar'])
}

fileTree(dir: 'libs/testCompile', include: '**/*.aar')
        .each { File file ->
    dependencies.add("testCompile",
            [name: file.name.lastIndexOf('.').with { it != -1 ? file.name[0..<it] : file.name }, ext: 'aar'])
}

fileTree(dir: 'libs/androidTestCompile', include: '**/*.aar')
        .each { File file ->
    dependencies.add("androidTestCompile",
            [name: file.name.lastIndexOf('.').with { it != -1 ? file.name[0..<it] : file.name }, ext: 'aar'])
}