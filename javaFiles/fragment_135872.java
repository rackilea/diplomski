public void Test()
{
    _driver = new FirefoxDriver();
    _driver.Navigate().GoToUrl(Url);
    _driver.Manage().Window.Maximize();
    _driver.FindElement(By.Id("CN1")).SendKeys("7203002");
    _driver.FindElement(By.Id("CN2")).SendKeys("0370");
    _driver.FindElement(By.XPath("//*[@id='InputDay']/option[@value='23']")).Click();
    _driver.FindElement(By.XPath("//*[@id='InputMonth']/option[@value='02']")).Click();
    _driver.FindElement(By.XPath("//*[@id='InputYear']/option[@value='15']")).Click();
    _driver.FindElement(By.Id("NextButton")).Click();
    _driver.FindElement(By.XPath("//label[.='Lunch']//../span")).Click();
    _driver.FindElement(By.XPath("//label[.='Dining room']//../span")).Click();

}