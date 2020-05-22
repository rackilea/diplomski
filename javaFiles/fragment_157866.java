//Click send
driver.findElement(By.xpath("//div[text()='Send']")).click();

//wait for element to disappear

waitForElementToDisappear(By.xpath("//div[contains(text(),'Loading')]"));

or

 //wait for element to appear
waitForElementToAppear(By.id("link_undo"));


    void waitForElementToDisappear(By locator)
    {
                int i=0;
                while(isElementPresent(locator))
                {
                    Thread.sleep(100);
                    i++;
                    if(i>50)
                    {
                        break;
                    }
                }
    }

   void waitForElementToAppear(By locator)
    {
                int i=0;
                while(!isElementPresent(locator))
                {
                    Thread.sleep(100);
                    i++;
                    if(i>50)
                    {
                        break;
                    }
                }
    }