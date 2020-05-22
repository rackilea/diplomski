public static String makeScreenshot() {
    String fileName = System.currentTimeMillis() + "Test";
    File screenshot = Driver.driver.get().getScreenshotAs(OutputType.FILE);
    File outputFile = new File("LoggerScreenshots/" + fileName + ".png");
    System.out.println(outputFile.getAbsolutePath());
    try {
        FileUtils.copyFile(screenshot, outputFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return outputFile.getName();
}