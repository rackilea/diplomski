boolean displayed = false;
    List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div[1]/div/div/div/div[2]/table/tbody/tr[1]/td[4]/a"));
    while (!displayed) {
        if (element.size() > 0) {
            // Element is found so set the boolean as true
            displayed = true;
            // Click on the element
            element.get(0).click();
        } else {
            // Adding a static sleep of 10 seconds, this else condition can be removed also
            Thread.sleep(10000);
        }
    }