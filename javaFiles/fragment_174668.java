ChromeOptions options = new ChromeOptions();
options.addArgument("headless");
options.addArgument("window-size=1920,1080");

// or

options.addArguments("headless", "window-size=1920,1080");