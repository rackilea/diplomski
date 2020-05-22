DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
 ChromeOptions options = new ChromeOptions();

 options.addArguments("user-data-dir=C:\\Users\\"+System.getenv("USERNAME")+"\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
 driver = new ChromeDriver(desiredCapabilities);