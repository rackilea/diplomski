jfxmobile {
    ios {
        forceLinkClasses = [ 'com.gluonapplication.**.*', 'com.mysql.**.*']
        infoPList = file('src/ios/Default-Info.plist')
    }
}