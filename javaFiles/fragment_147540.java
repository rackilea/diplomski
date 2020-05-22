public void TestToolTip()
{
    //Assuming that's the only element with that class name
    //If that's not case adjust the selector accordingly
    //you also have to make sure the element exist as well
    //otherwise it will throw NoSuchElement(or similar) exception
    By by = By.cssSelector("p.nav_p");

    WebElement toolTipElement = driver.findElement(by);
    //the following action should make the tooltip visible
    //if this is not the element on which the click
    //event generates tool to visible, adjust accordingly.
    toolTipElement.click();


    //In this stage just check if the element is visible/displayed or not
    if (!toolTipElement.isDisplayed() || !toolTipElement.getText().contains("Give it purpose—fill it with books, movies, mobiles, cameras, toys and fashion jewellery."))
    {
        //is not displayed or does not contain the expected text so fail the test
        Assert.fail();
    }
     else
    {

    }
}