WebElement elm = driver.findElement(By.id("btn1"));
Actions builder = new Actions(driver);
Action act = builder.clickAndHold(elm).build();
act.perform();
try {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\Img\\screenshot.png"));
} catch (IOException e) {
    e.printStackTrace();
}
act = builder.release(elm).build();
act.perform();