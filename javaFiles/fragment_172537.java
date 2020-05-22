for (int i = 0; i < driver.Manage().Cookies.AllCookies.Count - 1; i++)
{
   System.Net.Cookie ck = new
   System.Net.Cookie(driver.Manage().Cookies.AllCookies[i].Name, driver.Manage().Cookies.AllCookies[i].Value, driver.Manage().Cookies.AllCookies[i].Path, driver.Manage().Cookies.AllCookies[i].Domain);
   //here you can add it to your cookie list.
}