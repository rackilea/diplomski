List<WebElement> elementxb1 = driver.findElements(By.xpath("//input[@name='contractPeriod']"));

for (WebElement element : elementxb1){
    boolean vapval2b = element.isSelected();

        if(vapval2b)
        {
                System.out.println("Yes Button is selected ? : " + vapval2b); 
        }
        else 
        {
            System.out.println("No Button is not selected, click on it. ? :" + vapval2b); 
            // click on the radio button here.
            if(element.isDisplayed())
               element.click();
            else{((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
           }

        }
}