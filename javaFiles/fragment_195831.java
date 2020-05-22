IOSDriver driver = new IOSDriver();
    driver.get("url to be opened");
    WebElement ele = driver.findElement(By.xpath("xpathOfElementToBeclicked"));

    ele.click(); //New window opens

    Set<String> contextView = ((AppiumDriver)driver).getContextHandles();
    ArrayList<String> s = new ArrayList<String>(contextView);        
    ((AppiumDriver)driver).context(s.get(contextView.size()-1));
    driver.close();