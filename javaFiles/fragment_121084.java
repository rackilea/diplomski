@DataProvider(parallel = true)
public Object[][] testData(ITestContext context) {
    //Here We are trying to read the value of
    // <parameter name="dev" value="true"/> 
    //from the suite xml file.
    String dev = context.getCurrentXmlTest().getAllParameters().get("dev");
    String path;
    if (dev.equals("true")) {
        path = System.getProperty("user.dir") + "\\src\\data\\dev-data.xlsx";
    } else {
        path = System.getProperty("user.dir") + "\\src\\data\\reg-data.xlsx";
    }
    //Rest of the data provider code goes here.
    return new Object[][] {{}};
}