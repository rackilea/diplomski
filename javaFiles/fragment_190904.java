JavascriptExecutor js = (JavascriptExecutor)driver;

        while(true){

            Long height=(Long) js.executeScript("return document.body.scrollHeight");
            System.out.println(height);
            Thread.sleep(1000);
            driver.findElement(By.tagName("body")).sendKeys(Keys.END);        

            if (height==0)
            {
                break;
            }               

        }