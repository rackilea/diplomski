GraphicsConfiguration config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
if (!AWTUtilities.isTranslucencyCapable(config)) {
    System.out.println("Transluceny is not supported");
}

if (!AWTUtilities.isTranslucencySupported(AWTUtilities.Translucency.PERPIXEL_TRANSPARENT)) {
    System.out.println("PerPeixel Transparency is not supported");
}