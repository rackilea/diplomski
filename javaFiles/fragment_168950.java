if (driver.findElements(By.xpath(".//*[@id='UserBody']/tr[1]/td[1]") ).size()!= 0)
      {
         int j;
     for (j=1 ; j< 10; j++)
     {
         String ExistUser = driver.findElement(By.xpath(".//*[@id='UserBody']/tr["+j+"]/td[1]")).getText();
         //String value = ExistUser.getAttribute("value");
         System.out.println(ExistUser);

     }
      }