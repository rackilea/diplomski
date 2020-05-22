private By selectLocator = By.id("edit-term");
public static boolean ajaxFunctionalityFF() throws InterruptedException
{
    ...
    Select ajaxSelector = getSelect();
    ...
    ajaxSelector = getSelect();
    ajaxSelector.selectByVisibleText("-Cattle");
    ...
}
public static Select getSelect()
{
    return new Select(driver.findElement(selectLocator));
}