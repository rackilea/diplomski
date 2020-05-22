public SoftAssert softAssert;

@BeforeMethod
public void setup() {
    softAssert = new SoftAssert();
}

@AfterMethod
public void tearDown() {
    softAssert = null;
}

// ...