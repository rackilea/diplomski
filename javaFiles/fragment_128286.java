driver.get("http://logos.iti.gr/logos/");
    WebElement el = driver.findElement(By.id("fileToUpload"));
    System.out.println("Making element visible");  
    ((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block';", el);
    el.clear();
    System.out.println("Cleared");              
    el.sendKeys("/home/test.jpg");