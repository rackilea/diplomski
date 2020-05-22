driver.get("http://select2.github.io/select2/");
    WebElement select = driver.findElement(By.xpath("//div[contains(@class,'select2-container')]"));
    select.click();
    String optionText="Alaska";
    List<WebElement> options=driver.findElements(By.xpath("//div[@class='select2-result-label'][text()='"+optionText+"']"));
    if(options.isEmpty())
        System.out.println("Option not present");
    else
        System.out.println("Present");