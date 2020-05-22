// If your test device list had 3 iOS channels and 2 Android channels, you 
// would build your audience like this
Selector testDevices = Selectors.or(
    Selectors.iosChannels("ios-channel1", "ios-channel2", "ios-channel3"),
    Selectors.androidChannels("android-channel1", "android-channel2")
);