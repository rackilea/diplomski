// Find all div elements with class "sp-preview-inner"
List<WebElement> elements = driver.findElements(
    By.cssSelector("div[class='sp-preview-inner']"));

// Click all of them
elements.forEach(WebElement::click);