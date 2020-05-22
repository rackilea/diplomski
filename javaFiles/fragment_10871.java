DesiredCapabilities capabilities;
capabilities = new DesiredCapabilities();       
capabilities.setJavascriptEnabled(true);
capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "drivers/phantomjs.exe");
capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX,"Y");
capabilities.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:16.0) Gecko/20121026 Firefox/16.0");

//intialize driver and set capabilties

driver = new PhantomJSDriver(capabilities);