public static Component getMostRecentFocusOwner(Window window) {
    try {
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        Method getMostRecentFocusOwner = KeyboardFocusManager.class.getDeclaredMethod("getMostRecentFocusOwner", Window.class);
        getMostRecentFocusOwner.setAccessible(true);
        return (Component) getMostRecentFocusOwner.invoke(focusManager, window);
    } catch (Exception ignored) {}
    return null;
}