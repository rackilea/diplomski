//open a mail from the gmail inbox.
List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
            System.out.println(a.size());
            for (int i = 0; i < a.size(); i++) {
                System.out.println(a.get(i).getText());
                if (a.get(i).getText().equals("Support")) //to click on a specific mail.
                    {                                           
                    a.get(i).click();
                }
            }