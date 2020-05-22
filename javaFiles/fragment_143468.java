FirefoxProfile oProfile = new FirefoxProfile();
        File extension = new File("scrapbook-1.5.11-fx.xpi");
        try {
            oProfile.addExtension(extension);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebDriver driver = new FirefoxDriver(oProfile);
        driver.get("https://google.com");
        new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT, "D")).perform();