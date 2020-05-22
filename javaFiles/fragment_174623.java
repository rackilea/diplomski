ChromeOptions options = new ChromeOptions();
options.addArguments("headless");
// Must maximize Chrome by `start-maximized`
options.addArguments("start-maximized");

//Dont maximize Chrome by below line, because has no display
driver.manage().window().maximize()