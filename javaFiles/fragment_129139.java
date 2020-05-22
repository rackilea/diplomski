public void verifyLoginPage()
{
    new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Guru99");
    String homepage= "Guru99 Bank Manager HomePage";
    if (driver.getTitle().equalsIgnoreCase(homepage))
        System.out.println("Its the correct Homepage after Login");
    else
        System.out.println("Page after login is not the intended one");
}