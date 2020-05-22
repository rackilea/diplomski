[Test]
    public void Test3()
    {
        string currencyToSet = "EUR";

        IWebElement currencyDropDown = driver.FindElement(By.CssSelector("button[class='btn btn-link dropdown-toggle']"));
        currencyDropDown.Click();

        //Locate the Currency
        IWebElement currencyVal = driver.FindElement(By.Name(currencyToSet.ToUpper()));

        //Before clicking Currency, store Currency Name in a variable.
        string currencyName = currencyVal.Text;

        //Print Currency Name
        Console.WriteLine("Currency Name:" + currencyName);

        //Click on Currency
        currencyVal.Click();

        //Extract Currency Symbol from Currency Name
        string[] spittedCurrencyName = currencyName.Split(' ');
        string currencySymbol = spittedCurrencyName[0];

        //Now you have Currency Symbol. Therefore, you can easily compare it with what is set. 
        Console.WriteLine("Currency Symbole: " + currencySymbol);
    }