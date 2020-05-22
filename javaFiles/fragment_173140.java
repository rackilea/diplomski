List<WebElement> allClass = driver.findElements(By.className("A"));
    String optionString = "BB"; 

    for(WebElement elm : allClass){
        WebElement header = elm.findElement(By.tagName("h1"));
        if(header.getText().equalsIgnoreCase(optionString)){
            WebElement thisP = elm.findElement(By.tagName("p"));
            thisP.click();
            break;
        }
    }