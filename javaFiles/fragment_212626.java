FirefoxProfile profile = new FirefoxProfile();
    profile.setPreference("network.proxy.type", 1);
    profile.setPreference("network.proxy.socks", "83.209.94.87");
    profile.setPreference("network.proxy.socks_port", 35923);

    FirefoxDriver driver = new FirefoxDriver(profile);
    driver.get("https://www.ipinfo.io");