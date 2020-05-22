import multiScreenShot.MultiScreenShot; 

WebElement object1 = driver.findElement(By.Id("MyObject"));
object1.click();
MultiScreenShot multiScreens = new MultiScreenShot("C:\\", "test"); // Path where you save the image
multiScreens.elementScreenShot(driver, object1);
WebElement object2 = driver.findElement(By.Id("YourObject"));
object2.click();
multiScreens.elementScreenShot(driver, object2);