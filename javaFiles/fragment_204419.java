private void hideDynamicElements() throws IOException, InterruptedException {
   List<By> criteria = Arrays.asList(
        By.className("telephone-number"),
        By.cssSelector("#chatContainer"),
        By.cssSelector("#demoFormChat"),
        By.className("reach-out"),
        By.cssSelector("div.cf.article-header"),
        By.className("js-blog-feed-container")
   );

   for(By crit : criteria) {
        List<WebElement> elements = driver.findElements(crit);

        hideElements(elements);
   }
}

private void hideElements(List<WebElement> elements) {
    for (WebElement hideElement : elements){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden'", hideElement);
    }
}