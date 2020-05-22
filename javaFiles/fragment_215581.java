boolean clicked = false;
    int attempts = 0;
    while(!clicked && attempts < 5) {
    try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
            clicked = true;
     } catch (Exception e) {
            System.out.println("Unable to wait and click on WebElement, Exception: " + e.getMessage());
            Assert.assertFalse(true, "Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
        }
         attempts++;
    }