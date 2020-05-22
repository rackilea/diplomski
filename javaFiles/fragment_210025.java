List<WebElement> elementxb1 = driver.findElements(By.xpath("//input[@name='contractPeriod']"));

for(int i11 = 0 ; i11< elementxb1.size() ; i11++){ 

      elem = elementxb1.get(i11).findElement(By.xpath("//input[@name='contractPeriod']"));
      boolean vapval2b = elem.isSelected();

        if(vapval2b)
        {
                System.out.println("Yes Button is selected ? : " + vapval2b); 
        }
        else 
        {
            System.out.println("No Button is not selected, click on it. ? :" + vapval2b); 
            // click on the radio button here.
        if(elem.isDisplayed())
           elem.click();
        else{((JavascriptExecutor)driver).executeScript("arguments[0].click();",elem);
        }
}