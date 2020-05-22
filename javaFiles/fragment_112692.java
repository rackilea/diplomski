driver.Navigate().GoToUrl("https://www.irctc.co.in/eticketing/loginHome.jsf");

        // will try looping as long as you're on the relevant page
        do
        {
            try
            {
                IWebElement username = w.Until(ExpectedConditions.ElementIsVisible(By.Id("usernameId")));
                IWebElement password = driver.FindElement(By.Name("j_password"));
                if (String.IsNullOrEmpty(username.GetAttribute("value")))
                {
                    username.SendKeys("a");
                    password.SendKeys("b");
                }
            }
            catch (Exception)
            { 
                // page is reloading, just wait another round
            }
        } while (!String.Equals(driver.Url, "put url after login here"));