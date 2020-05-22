JavascriptExecutor js = (JavascriptExecutor) getDriver();
js.executeScript("document.getElementById('filedata').style.display='inline-block';");

// RemoteWebDriver remoteWebDriver = (RemoteWebDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
// remoteWebDriver.setFileDetector(new LocalFileDetector());
// WebElement input = remoteWebDriver.findElement(By.id("fileinputfield"));
// input.sendKeys(filePath);

js.executeScript("document.getElementById('filedata').style.display='none';");