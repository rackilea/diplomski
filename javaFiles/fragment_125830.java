public String getTextFromWebElements() {
        StringBuilder stringOne = new StringBuilder();
        List<WebElement> listOfWebElements = driver.findElements(By.cssSelector(".events-stuff-morestuff"));
        char SEPARATOR = '\0';
        for (WebElement we : listOfWebElements) {
            stringOne.append(SEPARATOR);              
            stringOne.append(we.getText());
            SEPARATOR = ',';
    }
    return stringOne.toString();
}