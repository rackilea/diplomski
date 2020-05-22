displayNameTextbox = driver.findElement(By.cssSelector(CONSTANTs.DISPLAY_NAME_TXTBOX));
if(displayNameTextbox.isDisplayed())
{
    log.step("Optional..... BUT you will need it when Commenting on any article....");
    elementPresent_Click(By.cssSelector(CONSTANTs.DISPLAY_NAME_TXTBOX), displayName);

}