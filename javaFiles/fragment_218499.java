DisplayMode oldDisplayMode = myDevice.getDisplayMode();
try {
    myDevice.setFullScreenWindow(myWindow);
    myDevice.setDisplayMode(newDisplayMode);
    ...
} finally {
    myDevice.setDisplayMode(oldDisplayMode);
    myDevice.setFullScreenWindow(null);
}