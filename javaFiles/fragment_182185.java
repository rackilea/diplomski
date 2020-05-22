public static boolean isMyFontSupported(String fontname) {
    GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    for (String installedFont : graphicsEnvironment.getAvailableFontFamilyNames()) {
        if (installedFont.equalsIgnoreCase(fontname)) {
            return true;
        }
    }
    return false;
}