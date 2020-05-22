BrowserMobProxy server = new BrowserMobProxyServer();
server.start();

Proxy proxy = ClientUtil.createSeleniumProxy(server);

DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
capabilities.setCapability(InternetExplorerDriver.IE_USE_PRE_PROCESS_PROXY, true);
capabilities.setCapability(CapabilityType.PROXY, proxy);

WebDriver driver = new InternetExplorerDriver(capabilities);