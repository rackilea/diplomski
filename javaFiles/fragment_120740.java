public synchronized BufferedImage createScreenCapture(Rectangle screenRect) {
    checkScreenCaptureAllowed();
    //... proceed
}

private static void checkScreenCaptureAllowed() {
    SecurityManager security = System.getSecurityManager();
    if (security != null) {
        security.checkPermission(
            SecurityConstants.AWT.READ_DISPLAY_PIXELS_PERMISSION);
    }
}