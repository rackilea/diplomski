public static void assertContains(WebElement outer, WebElement inner) {
    // e.g. //div[text()='some text in inner element']
    final String findInner = ".//" + inner.getTagName() + "[text()='" + inner.getText() + "']";
    try {
        outerElem.findElement(By.xpath(findInner));
    } catch (NoSuchElementException ignored) {
        fail("Some horrible message! We are all doomed!");
    }
    // passed
}