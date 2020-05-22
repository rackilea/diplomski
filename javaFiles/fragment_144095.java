try {
    WebElement existingPage = driver.findElement(By.cssSelector("select[id^=page]"));
    // ...
} catch (NoSuchElementException e) {
    // no pages found
}