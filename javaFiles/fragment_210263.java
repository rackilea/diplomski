WebDriverWait wait = new WebDriverWait(driver, 10 /*timeout in seconds*/);
                           if(wait.until(ExpectedConditions.alertIsPresent())==null){
                                 System.out.println("alert was not present");
                           }
                           else
                           {
                            Alert alert = driver.switchTo().alert();
                           alert.accept();
                           System.out.println("alert was present and accepted");
                           }