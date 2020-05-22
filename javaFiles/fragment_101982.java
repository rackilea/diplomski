String text_in_panel=null;
    try{
        //waiting 20 seconds for the visibility of the element
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'panelMessage')]/span[1]")));

        //Retrieving the text from the element
        text_in_panel = element.getText();
    }catch(Throwable e){
        System.err.println("Element is not visible: "+e.getMessage());
    }

    //Comparing the text with the hard-coded value
    if(text_in_panel.equals("£163.06"))
        System.out.println("Text matches");
    else
        System.err.println("Text doesn't match");