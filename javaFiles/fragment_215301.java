// Checking the posted text
WebElement postedtext= driver.findElement(By.cssSelector("css123"));
myAssertTrue("The text is verfied",postedtext.getText().equals(enteredText));

private static void myAssertTrue(String string, boolean equals) {
    try {
        assertTrue(string,equals);
    } catch (AssertionError e) {
        System.out.println(e.getMessage());
        throw e;
    }
}