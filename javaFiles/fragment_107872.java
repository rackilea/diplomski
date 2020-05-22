File src = new File("C:\\Utility\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
System.setProperty("phantomjs.binary.path", src.getAbsolutePath());

DesiredCapabilities dcap = new DesiredCapabilities();
String[] phantomArgs = new  String[] {
    "--webdriver-loglevel=NONE"
};
dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
PhantomJSDriver driver = new PhantomJSDriver(dcap);

driver.get("https://www.facebook.com/");