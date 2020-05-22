WebDriverWait waiter = new WebDriverWait(driver, 5, 200);
waiter.ignoring(AssertionFailedError.class);
waiter.ignoring(StaleElementReferenceException.class);
waiter.until(new ExpectedCondition<Boolean>()
{
    public Boolean apply(WebDriver input)
    {
        WebElement feedback = input.findElement(By.id("feedback"));
        Assert.assertTrue("Feedback not was not empty, but was: " + feedback.getText(), feedback.getText().isEmpty());            
        return true;
    }
});