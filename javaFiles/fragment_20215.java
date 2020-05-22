@Test
private void srch() throws MalformedURLException, IOException  {


         driver.get(TestURL);
         WebElement input1 = driver.findElement(By.id("login_form_user_input"));
         input1.sendKeys("guest");
         WebElement input2 = driver.findElement(By.id("login_form_password_input"));
         input2.sendKeys("guest");
         WebElement btn = driver.findElement(By.id("login_form_signin_button"));
         btn.click();
         WebElement w1 = driver.findElement(By.id("header_search_text_field"));
         w1.sendKeys("tsk");
         WebElement srch = driver.findElement(By.id("header_search_button"));
         srch.click();
         WebDriverWait wait= new WebDriverWait(driver,20 );
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("td")));
         WebElement table = driver.findElement(By.id("search_results_table"));
         List <WebElement> rst = table.findElements(By.tagName("b"));
         for (int i=0 ; i< rst.size(); i++)
         {
             System.out.println(rst.get(i).getText());
         }







      }