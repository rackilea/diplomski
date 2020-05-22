List<WebElement> elements= driver.findElements(By.xpath("//table/tbody/tr"));

    int i =0 ;

    while(i<elements.size()){

        WebElement childElement =  elements.get(i).findElement(By.cssSelector("a"));

    System.out.println(childElement.getAttribute("href"));

    i++;
    }