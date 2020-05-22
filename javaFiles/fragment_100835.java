public void openTestSite() {

    //driver.navigate().to(the URL for the website);
    driver.get("https://wonef.fr/try/");
    driver.manage().window().maximize();
    //Explicit wait is added after the Page load
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.titleContains("WoNeF"));
}