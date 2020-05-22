private void createHook() {
    try {
        // here you starts the hook
        GlobalScreen.registerNativeHook();
    } catch (NativeHookException ex) {
        //TODO Exception handling
    }

    // here you add the listener for the hook
    GlobalScreen.addNativeMouseListener(this);
}