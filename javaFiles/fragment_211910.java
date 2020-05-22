import java.io.IOException;

public class Kill_ChromeDriver_GeckoDriver_IEDriverserver 
{
    public static void main(String[] args) throws Exception 
    {
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
    }
}