private By getByFromElement(WebElement element) {

    By by = null;
    String[] selectorWithValue= (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

    String selector = selectorWithValue[0].trim();
    String value = selectorWithValue[1].trim();

    switch (selector) {
        case "id":
            by = By.id(value);
            break;
        case "className":
            by = By.className(value);
            break;
        case "tagName":
            by = By.tagName(value);
            break;
        case "xpath":
            by = By.xpath(value);
            break;
        case "cssSelector":
            by = By.cssSelector(value);
            break;
        case "linkText":
            by = By.linkText(value);
            break;
        case "name":
            by = By.name(value);
            break;
        case "partialLinkText":
            by = By.partialLinkText(value);
            break;
        default:
            throw new IllegalStateException("locator : " + selector + " not found!!!");
    }
    return by;
}