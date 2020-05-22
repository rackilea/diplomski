public static String takeScreenShot(String caption)  {
    String filename = getFilename(caption);

    try {
        TakesScreenshot camera = (TakesScreenshot)driver;
        File scrFile = camera.getScreenshotAs(OutputType.FILE);

        FileUtils.moveFile(scrFile, new File(captureDir + sep + filename));
        System.out.println("Saved to: " + captureDir + sep + filename);
    } catch (Exception e) {
        System.out.println("Cannot take a screenshot");
    }

    return filename;
}