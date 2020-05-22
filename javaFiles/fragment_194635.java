package Java_Experiments;

public class system_getProperty {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        System.out.println(System.getProperty("subliminal.message", "Selenium WebDriver!"));
        System.out.println("Java Runtime Environment version: "+System.getProperty("java.version"));
        System.out.println("Java Runtime Environment vendor: "+System.getProperty("java.vendor"));
        System.out.println("Java vendor URL: "+System.getProperty("java.vendor.url"));
        System.out.println("Java installation directory: "+System.getProperty("java.home"));
    }
}