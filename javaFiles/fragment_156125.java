Thread.sleep(5000);
      driver.findElement(By.xpath("//li[text()='Price -- High to Low']")).click();

      Thread.sleep(5000);
      List<WebElement> element =  driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

      element.get(0).click();