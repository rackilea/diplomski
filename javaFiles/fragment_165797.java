WebElement element = 
    driver.findElement(By.xpath("//*[@id='IncidentSearch']/tbody/tr/td[33]"));
    if (element.getText().equals("timeToResponse")))
     System.out.println("Match found");
    else 
     System.out.println("Match Not found");
   Assert.assertEquals(element.getText(), "timeToResponse");