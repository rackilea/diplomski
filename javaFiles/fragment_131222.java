synchronized (BrowserManager.class) {
            switch (browserName) {
                case "firefox":
                    FirefoxDriverManager.getInstance().setup();
                    System.out.println("Registering    FIREFOX");
                    break;
                case "chrome":
                    ChromeDriverManager.getInstance().setup();
                    System.out.println("Registering    CHROME");
                    break;
            }
        }