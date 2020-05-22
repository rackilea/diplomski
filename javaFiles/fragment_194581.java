Driver driver = null;
switch (browserId){
case 1: 
    driver = new FirefoxDriver();
    break;
case 2:
    driver = new InternetExplorerDriver();
    break;
default: 
    System.out.println("An error has occurred, the program will now close.");
    System.exit(0);
}