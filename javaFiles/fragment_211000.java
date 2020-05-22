catch(Exception e)
{
    if(e instanceof org.openqa.selenium.WebDriverException)
        sendException("Problem is with the selenium web driver");
    else if(e.getClass().getPackage().startsWith("java.net"))
        sendException("There is some problem with the network");
}