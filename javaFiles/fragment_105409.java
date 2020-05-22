public bool Test()
{
    try
    {

        Driver.FindElement(By.Id("test"));
        return true;
    }
    catch (Exception ex)
    { // catch the exception you want
        return false;
    }
}

public void TestAssert()
{
    Assert.AreEqual(Test(),false);
}