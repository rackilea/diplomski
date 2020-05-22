Actions hover = new Actions(driver);

WebElement Elem_to_hover = driver.findElementBy(By.id("id"));

hover.moveToElement(Elem_to_hover);

hover.build();

hover.perform();