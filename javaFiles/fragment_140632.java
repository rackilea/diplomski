private static ResourceBundle _prop = ResourceBundle.getBundle("dev");
//Load standalone executable if required
switch (browserType) {
    case CHROME:
        if (System.getProperties().getProperty("os.arch").toLowerCase().equals("x86_64") || System.getProperties().getProperty("os.arch").toLowerCase().equals("amd64")) {
            if (System.getProperties().getProperty("os.name").toLowerCase().contains("windows")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/windows/googlechrome/64bit/26/chromedriver.exe");
            } else if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/osx/googlechrome/64bit/26/chromedriver");
            } else if (System.getProperties().getProperty("os.name").toLowerCase().contains("linux")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/linux/googlechrome/64bit/26/chromedriver");
            }
        } else {
            if (System.getProperties().getProperty("os.name").toLowerCase().contains("windows")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/windows/googlechrome/32bit/26/chromedriver.exe");
            } else if (System.getProperties().getProperty("os.name").toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/osx/googlechrome/32bit/26/chromedriver");
            } else if (System.getProperties().getProperty("os.name").toLowerCase().contains("linux")) {
                System.setProperty("webdriver.chrome.driver", _prop.getString("binaryRootFolder") + "/linux/googlechrome/32bit/26/chromedriver");
            }
        }
        break;
    case IE:
        if (System.getProperties().getProperty("os.arch").toLowerCase().equals("x86_64") || System.getProperties().getProperty("os.arch").toLowerCase().equals("amd64")) {
            System.setProperty("webdriver.ie.driver", _prop.getString("binaryRootFolder") + "/windows/internetexplorer/64bit/2.29.0/IEDriverServer.exe");
        } else {
            System.setProperty("webdriver.ie.driver", _prop.getString("binaryRootFolder") + "/windows/internetexplorer/32bit/2.29.0/IEDriverServer.exe");
        }
        break;
}