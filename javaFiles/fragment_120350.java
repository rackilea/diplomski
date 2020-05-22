public class Testng {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        switch(System.getProperty("env")) {
            case "int":
                return new Object[][] { { "int data one" }, { "data two" } };
            case "stg":
                return new Object[][] { { "stage data one" }, { "data two" } };
            case "prod":
                return new Object[][] { { "production data one" }, { "data two" } };
            default:
                return new Object[][] { { "int data one" }, { "data two" } };
        }
    }

    @Test(enabled = true, dataProvider = "data-provider", dataProviderClass = Testng.class)
    public void test(String data) {
        System.out.println(data);
    }

}