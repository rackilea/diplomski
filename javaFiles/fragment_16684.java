// Set this property, in order to specify path that PhantomJS executable will use
System.setProperty("phantomjs.binary.path", System.getenv("PHANTOM_JS") + "/bin/phantomjs.exe");

// New PhantomJS driver from ghostdriver
WebDriver driver = new PhantomJSDriver();
driver.get("https://jqueryui.com/resources/demos/draggable/default.html");

// Find draggable element
WebElement draggable = driver.findElement(By.id("draggable"));

System.out.println("x: " + draggable.getLocation().x 
        + ", y: " + draggable.getLocation().y);

// Perform drag and drop
(new Actions(driver)).dragAndDropBy(draggable, 50, 0)
    .build()
    .perform();

System.out.println("x: " + draggable.getLocation().x 
        + ", y: " + draggable.getLocation().y);