public void clickSupercarsLink() throws Exception {
this.wait = new WebDriverWait(driver, 30);
Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(link_Supercars)).isEnabled();
try {
    if (elementPresent == true) {
        link_Supercars.click();
    }
} catch (StaleElementReferenceException elementUpdated){
    link_Supercars = driver.findElement(myLocator);
    if (elementPresent == true) {
        link_Supercars.click();
    }
} catch (Exception e) {
    System.out.println("Exception! - could not click on supercars link: " + e.toString());
    throw (e);
} finally {
}