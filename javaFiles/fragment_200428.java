public By categoriesLocator = By.xpath("//*[@id='menu-posts']/div[3]/div/ul/li[3]/a");

public void menus()
{
    try
    {
        loginTest();
        menuPosts.click(); // why aren't you using waitClick() here?
        waitClick(categoriesLocator);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        driver.quit();
    }
}

public void waitClick(By locator)
{
    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(locator)).click();
}