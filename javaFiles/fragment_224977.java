private static Pointer getWindowPointer(Stage stage) {
    try {
        TKStage tkStage = stage.impl_getPeer();
        Method getPlatformWindow = tkStage.getClass().getDeclaredMethod("getPlatformWindow" );
        getPlatformWindow.setAccessible(true);
        Object platformWindow = getPlatformWindow.invoke(tkStage);
        Method getNativeHandle = platformWindow.getClass().getMethod( "getNativeHandle" );
        getNativeHandle.setAccessible(true);
        Object nativeHandle = getNativeHandle.invoke(platformWindow);
        return new Pointer((Long) nativeHandle);
    } catch (Throwable e) {
        System.err.println("Error getting Window Pointer");
        return null;
    }
}