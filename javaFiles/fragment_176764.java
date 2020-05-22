List<WebElement> divList = WebDriver.findElement(By.xpath("//div[class='OuterDiv']")).findElements(By.tagName("div"));
    for(WebElement element : divList)
    {
       if(element.getAttribute("style").equals("display:none"));
       {
          divList.add(element);
          sysout(element.getAttribute("id"));
       }
    }