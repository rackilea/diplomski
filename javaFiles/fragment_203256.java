boolean reachedbottom = Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());

    while (!reachedbottom) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
        try {
            reachedbottom=Boolean.parseBoolean(js.executeScript("return $(document).height() == ($(window).height() + $(window).scrollTop());").toString());
            WebElement element = driver.findElement(By.xpath("//*[@id='http://static3.jassets.com/p/The-Indian-Garage-Co.-Checks-Red-Casual-Shirt-2889-679124-1-catalog.jpg']/img"));
            Wait<WebDriver> wait_element = new WebDriverWait(driver, 5);
            wait_element.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("!!!!!!!!!!!!!!At Last Get Success!!!!!!!!!!!!!!!!");
            break;
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }