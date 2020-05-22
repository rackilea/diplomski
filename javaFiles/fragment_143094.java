public static String selectByIndex(WebDriver driver, WebElement select, int index) {

        String javaScript = "var select = arguments[0]; "
                + "select.options[arguments[1]].selected = true;"
                + "return select.selectedOptions[0].text";

        return (String) ((JavascriptExecutor) driver).executeScript(javaScript, select, index);   
}


WebElement select = expedia.findElement(By.id("lineOfBusiness"));

Assert.assertEquals(selectByIndex(expedia, select, 1), "HWW Sales");