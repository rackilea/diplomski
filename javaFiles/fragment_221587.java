jfxmobile {
    android {
        manifest = 'src/android/AndroidManifest.xml'
    }

    ios {
        forceLinkClasses = [ 'your.package.**.*', 'SQLite.**.*']
        infoPList = file('src/ios/Default-Info.plist')
    }
}