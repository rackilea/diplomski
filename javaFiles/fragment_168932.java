try {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        if(isElementPresent(driver, By.xpath("//input[@type='radio' and @value='true']")){
            driver.findElement(By.xpath("//input[@type='radio' and @value='true']")).click();
        }
        sleep();

        driver.findElement(By.xpath("//input[@type='submit' and @value='>> valider <<']")).click();
        sleep();
 } catch (org.openqa.selenium.NoSuchElementException e) {
            e.printStackTrace();
 }