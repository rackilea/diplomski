public void clickHamburgerMenuAndContactLink() {
    WebDriverWait wait = new WebDriverWait(driver, 10000);
    hamburgerMenu.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-close")));
    contactLink.click();
}