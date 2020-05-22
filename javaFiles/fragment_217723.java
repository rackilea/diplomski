WebDriver driver=null;

Scanner scanner = new Scanner(System.in);

    //  prompt for the URL
    System.out.print("Enter your URL: ");

    // get their input as a String
    String URL = scanner.next();



    System.out.println( URL );
    final FirefoxProfile firefoxProfile = new FirefoxProfile();
    driver = new FirefoxDriver(firefoxProfile);
    driver.manage().window().maximize();

    driver.get(URL);