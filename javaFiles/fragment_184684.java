public WebElement getDropDownValueRandomly() {
    Random random = new Random();
    int x = random.nextInt(30) + 1;
    WebElement valueFromDropDown = driver.findElement(By.id("uxMiniFinderVoyageSelect_chzn_o_" + x));

    return valueFromDropDown;

}