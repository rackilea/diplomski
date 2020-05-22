for(WebElement link : driver.findElements(By.xpath("//img[@alt='Online Now!']/../..//a"))){             
            String originalWindow =driver.getWindowHandle();
            System.out.println("Original handle is: "+ originalWindow);
//open link in new window
            act.contextClick(link).perform();
            act.sendKeys("w").perform();

            Thread.sleep(4000);
            for (String newWindow : driver.getWindowHandles())
            {
            driver.switchTo().window(newWindow); 
            System.out.println("NOW THE CURRENT Handle is: "+ newWindow);
            }
            Thread.sleep(2000);
//here write a message              
            driver.close();
            driver.switchTo().window(originalWindow);
}