WebDriverWait wait = new WebDriverWait(driver, 10);

driver.findElement(By.cssSelector(".c-sort-filter")).click();

List<WebElement> checkboxes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".c-checkbox label")));
List<String> labels = checkboxes.stream().map(WebElement::getText).collect(Collectors.toList());

for (String label: labels) {
    driver.findElement(By.cssSelector(String.format("label[for='%s']", label))).click();
    // wait until loading disappear
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".c-spinner")));

    // check if input is selected
    wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(String.format("input[id='%s']", label))));
}

// check if input is selected by compare tags with checkboxes
List<String> selectedFilters = driver.findElements(By.cssSelector(".divider-view-filters-list .c-xbubble")).stream().map(WebElement::getText).collect(Collectors.toList());
Assert.assertEquals(selectedFilters, labels);