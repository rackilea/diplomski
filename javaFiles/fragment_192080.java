Robot rb =new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_T);
rb.keyRelease(KeyEvent.VK_CONTROL);
rb.keyRelease(KeyEvent.VK_T);
new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));
driver.get("https://stackoverflow.com");