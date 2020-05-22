public static void takeScreenshot(String screenshotPathAndName, WebDriver driver) {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {

        int height = driver.manage().window().getSize().getHeight();
        BufferedImage img = ImageIO.read(scrFile);
        BufferedImage dest = img.getSubimage(0, 0, img.getWidth(), height);
        ImageIO.write(dest, "png", scrFile);

        FileUtils.copyFile(scrFile, new File(screenshotPathAndName));
    } catch(Exception e) {
        e.printStackTrace();
    }
}