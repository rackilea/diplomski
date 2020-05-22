Proxy proxy = new Proxy(); 
proxy.setHttpProxy("yoururl:portno"); 
proxy.setSslProxy("yoururl:portno"); 

DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
capabilities.setCapability("proxy", proxy); 

ChromeOptions options = new ChromeOptions(); 
options.addArguments("start-maximized"); 

capabilities.setCapability(ChromeOptions.CAPABILITY, options); 

driver = new ChromeDriver(capabilities);