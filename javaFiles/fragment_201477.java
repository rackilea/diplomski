List<WebElement> EngDesc = driver.findElements(By.xpath("//input[@id='EngDesc']"));
    System.out.println("List size: "+EngDesc.size());
    for(WebElement list : EngDesc )
    {
        System.out.println("search value: "+list.getAttribute("value"));
        if(list.getAttribute("value").equals("CHARGEABLE")) 
        {
            System.out.println("This is General");   
        }
    }