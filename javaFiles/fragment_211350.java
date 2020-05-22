public class Example  {

SeleniumServer server = null;
Selenium selenium = null;
HttpCommandProcessor proc = null;

@Before
public void setUp() throws Exception {
    RemoteControlConfiguration config = new RemoteControlConfiguration();
    config.setUserExtensions(new File("bin/selenium/user-extensions.js"));
    server = new SeleniumServer(config);

    server.boot();

    proc = new HttpCommandProcessor("localhost",
            4444,
            "*firefox",
            "http://test");

    selenium = new DefaultSelenium(
             proc);
    selenium.start();
    selenium.open("http://test");

}
@Test      
public String justATest() {
    execCommand("waitForElementClickable", "scLocator=//Window[ID=\"errorWindow\"]/item[0][Class=\"Label\"]/");
    String elementTest = selenium.getText("scLocator=//Window[ID=\"errorWindow\"]/item[0][Class=\"Label\"]/");
    assertEquals(elementTest, "lorem");
}
protected String execCommand(String command, String locator) {
    String[] locatorArg = {locator};
    return proc.doCommand(command, locatorArg);
}

@After
public void stopSelenium() {
    System.out.println("in after hook");
    if (selenium != null) {
        selenium.deleteAllVisibleCookies();
        selenium.stop();
    }

    if (server != null) {
        server.stop();
    }
    System.out.println("after after hook");
}
}