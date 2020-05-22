public static boolean isOnTop(WebElement element) {
    WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

    return (boolean)((JavascriptExecutor)driver).executeScript(
        "var elm = arguments[0];" +
        "var doc = elm.ownerDocument || document;" +
        "var rect = elm.getBoundingClientRect();" +
        "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
        , element);
}