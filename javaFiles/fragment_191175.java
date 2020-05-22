@Before
public static final Environment.DriverToUse USED_DRIVER = Environment.DriverToUse.FIREFOX;

@Test
public void testVersionNumber() throws Exception{

    TestUI testUI= new TestUI(USED_DRIVER);
    WebElement version = testUI.getDriver().findElement(By.id("the Id of element"));
    version.click();
    //...
}