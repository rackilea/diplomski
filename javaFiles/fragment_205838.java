@BeforeTest(alwaysRun = true)
     public static void starttest() {
            logger = new ExtentLoggerReporter(System.getProperty("user.dir"));
            extent = new ExtentReports();
            extent.attachReporter(logger);
            System.err.close(); // written to remove JAVA 9 incompatibility.. continued below
            System.setErr(System.out); // continue.. and remove the warnings
            extent.setSystemInfo("User Name" , "Sobhit");
     }