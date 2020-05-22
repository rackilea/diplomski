public void kenshoSearch(String searchTerm) throws Exception
{
    driver.findElement(kenshoSearchBox).sendKeys(searchTerm);
    if (driver.findElements(kenshoSearchVerify).isEmpty() && driver.findElements(kenshoSearchVerify).isEmpty())
    {
        Assert.fail("Something's wrong with the search!");
    }
}