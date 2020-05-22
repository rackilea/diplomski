--------------------------------------

String location = "City of Sugar Land";
            driver.findElement(By.xpath("//div[@id='regionSelectPopup']//label[.='ALL']/preceding-sibling::input[@type='checkbox']")).click();

    driver.findElement(By.xpath("//div[@id='regionSelectPopup']//label[.='ALL']/preceding-sibling::input[@type='checkbox']")).click();

    driver.findElement(By.xpath("//div[@id='regionSelectPopup']//label[.='"+ location +"']/preceding-sibling::input[@type='checkbox']")).click();
    -----------------------------------