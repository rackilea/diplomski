//code block
driver.findElement(By.name("submitted")).click();
try {
    new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='small-9 small-pull-1 column content']"), "invalid User Name or Password"));
    String text = driver.findElement(By.xpath("//*[@class='small-9 small-pull-1 column content']")).getAttribute("innerHTML");
    System.out.println(text);
    if (text.contentEquals("You have specified an invalid User Name or Password. Please check and try again") || text.contentEquals("Time Out") || text.contentEquals("Your Online/Mobile Banking User ID has been blocked. Please go to “Forgot Password” option to unblock it.")) 
    {
        Assert.fail("Unable to login to application");
    }
} catch (Exception e) {
    System.out.println("DAashboard is displayed");
    // rest of code block
}