public class AddNewCase {
    WebDriver driver;

    public AddNewCase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> Method1() throws Exception {
        List<String> List1; // declared here, added to below
        // ***some code***
        return List1;
    }

    public List<String> Method2() throws Exception {
        List<String> List2; // declared here, added to below
        // ***some code***
        return List2;
    }
}