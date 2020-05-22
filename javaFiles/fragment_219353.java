public WebElement element(String title) {
    for (WebElement el : list) {
        if (el.getText().equals(title)) {
            return el**.findElement(By.xpath("a")**;
        }
    }
    return null
}