public void takeSmallScreenshot(WebDriver driver, WebElement uiElem)
{
         File uiElementSrc = uiElem.getScreenshotAs(OutputType.FILE);
         try {
            FileUtils.copyFile(uiElementSrc, new File(".\\Screenshots\\"+uiElem.getText().substring(0,5)+".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

}