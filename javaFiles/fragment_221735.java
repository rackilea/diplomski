try
{
      if(usersname.isDisplayed())
    {
        System.out.println("Already Login");

    }
}
catch(Exception e)
{            
        new UserLogin(driver).doLogin(TestDataComman.username, TestDataComman.password);
}