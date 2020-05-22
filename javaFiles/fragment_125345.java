String parentHandle = driver.getWindowHandle();

// switch to the new window
for (String winHandle : driver.getWindowHandles()) {
    if (!winHandle.equals(parentHandle))
    {
        driver.switchTo().window(winHandle);
    }
}

//do something with the new window
element = driver.findElement(By.xpath(".//*[@id='email']"));
element.sendKeys(account);

element = driver.findElement(By.xpath(".//*[@id='pass']"));
element.sendKeys(password);

element = driver.findElement(By.xpath(".//*[@id='u_0_2']"));
countDownLatch.countDown();
countDownLatch.await();
element.click();
System.out.println("Click Done");

// switch back to the old window
driver.switchTo().window(parentHandle);

// if the new window is closed by its on
driver.switchTo().window(driver.getWindowHandle());