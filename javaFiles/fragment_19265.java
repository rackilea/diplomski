caps.setCapability("nativeWebTap",true);
 IOSDriver driver = null;
 try {
     driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
  } catch (MalformedURLException e) {
     e.printStackTrace();
 }

 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 driver.get("http://stackoverflow.com");
 WebElement ele = driver.findElement(By.xpath("(//div[@class='-details'])[1]"));
 ele.click();
 driver.quit();