List<WebElement> items = driver.findElements(By.cssSelector(".parent > "));
List<WebElement> firstElements = new ArrayList<>(WebElement);

boolean lookForFirst = true;
for (WebElement item : items) {
    if (item.getTagName().equals("table")) {
        if (lookForFirst) {
            firstElements.add(item);
            lookForFirst = false;
        }
    }
    else {
        lookForFirst = true;
    }
}