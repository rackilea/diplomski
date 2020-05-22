WebDriverWait wait = new WebDriverWait(driver, 15);
WebElement el8 = driver.findElement(By.cssSelector(".tag.dropdown.product_brm .downArrow.closed"));
wait.until(ExpexctedConditions.elementIsClickable(el8);
js.executeScript("arguments[0].click();", el8);

WebElement el9 = driver.findElement(By.xpath("//*[text()='Vanilla (V)']")); // selects value from first pop up
wait.until(ExpexctedConditions.elementIsClickable(el9);
js.executeScript("arguments[0].click();", el9);