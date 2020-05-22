ArrayList<String> cliArgsCap = new ArrayList<String>();
cliArgsCap.add("--proxy=127.0.0.1:1024");
// cliArgsCap.add("--proxy-auth=username:password");
cliArgsCap.add("--proxy-type=socks5");

DesiredCapabilities caps = new DesiredCapabilities();
caps.setJavascriptEnabled(true);
caps.setCapability("takesScreenshot", true);
caps.setCapability("screen-resolution", "1280x1024");
caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\USER\\Downloads\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");

caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);

Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);

driver = new PhantomJSDriver(caps);