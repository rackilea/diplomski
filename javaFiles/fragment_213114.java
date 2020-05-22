public class AllTests {
    public static void main(String[] args){

        WebDriver driver = OpenBrowser.chrome();

        OpenSite.dev(driver);

        Test.TC1(driver);
    }
}