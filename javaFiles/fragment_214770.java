try {
if (new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='small-9 small-pull-1 column content']"), "No Password Found for")))
             {
                String text = driver.findElement(By.xpath("//*[@class='small-9 small-pull-1 column content']")).getAttribute("innerHTML");
                System.out.println(text);
                if(text.contentEquals("No Password Found for"))
                {
                    driver.navigate().refresh();
                    Assert.fail("Unable to login to application");
                }
            }
}
catch(Exception){}
try{
if(new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='small-9 small-pull-1 column content']"), "Your Online/Mobile Banking User ID has been blocked. Please go to “Forgot Password” option to unblock it.")))
             {
                String retext = driver.findElement(By.xpath("//*[@class='small-9 small-pull-1 column content']")).getAttribute("innerHTML");
                System.out.println(retext);
                if(retext.contentEquals("Your Online/Mobile Banking User ID has been blocked. Please go to “Forgot Password” option to unblock it.")) 
                {
                    driver.navigate().refresh();
                    Assert.fail("Unable to login to application");
                }
            }
catch(Exception){}