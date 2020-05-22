WebElement radiobox = driver.findElement(By.xpath("//input[@id='radio-1']"));
        boolean isDisplayedstatus = radiobox.isDisplayed();
        System.out.println(isDisplayedstatus);
        boolean isEnabledstatus = radiobox.isEnabled();
        System.out.println(isEnabledstatus);
        boolean isSelectedstatus = radiobox.isSelected();
        System.out.println(isSelectedstatus);

        List<WebElement> ele = driver.findElements(By.xpath("//input[starts-with(@id, 'radio')]"));
        for(WebElement we:ele) {
            if(!we.isSelected()) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();",we);
                System.out.println("Clicked : " + we.getAttribute("id"));
               // we.click();
            }
        }