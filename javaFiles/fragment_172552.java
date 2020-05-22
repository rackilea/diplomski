public List<WebElement> waitElements(WebDriver driver, int timeout, By locator) throws InterruptedException {
    List<WebElement> elements = new ArrayList<>();
    for (int i = 0; i < timeout; i++) {
        elements = driver.findElements(locator);
        if (elements.size() > 0)
            break;

        System.out.println("Not!");
        Thread.sleep(1000);
    }

    return elements;
}