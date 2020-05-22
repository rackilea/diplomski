// using javaslang.collection.List
protected WebElement findElementByText(List<WebElement> webElements, String text) {
    return webElements
            .find(webElement -> Objects.equals(webElement.getText(), text))
            .getOrElseThrow(() -> new NoSuchElementException("No WebElement found containing " + text));
}

// using java.util.List
protected WebElement findElementByText(java.util.List<WebElement> webElements, String text) {
    return webElements
            .stream()
            .filter(webElement -> Objects.equals(webElement.getText(), text))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("No WebElement found containing " + text));
}