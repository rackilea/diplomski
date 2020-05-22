if (driver == null) {

    File fileIE = new File("src//test/java/iedriver.exe");
            System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());                

            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

            try {                                       
                driver = new InternetExplorerDriver(ieCapabilities);                                        
            } catch (Exception e) {                 
                throw new RuntimeException(e);
            }
       }