private void importSystemFonts() {
    Properties pr = null;
    try {
        pr = getEnvironmentVariables();
    } catch (Throwable e) {
    }
    String systemRoot = pr.getProperty("SystemRoot");
    Runtime runtime = Runtime.getRuntime();
    String fileSeperator = System.getProperty("file.separator");
    int r = FontFactory.registerDirectory(systemRoot + fileSeperator + "fonts");
}