JavascriptExecutor js = (JavascriptExecutor) driver;
    WebElement element = driver.findElement(By.cssSelector("#gmail-address-label > strong"));
    String fontWeight = (String) js.
            executeScript(
                    "return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');",
                    element);
    if (fontWeight.trim().equals("bold")) {
        System.out.println("Is Bold");
    } else {
        System.out.println("Not Bold - " + fontWeight);
    }