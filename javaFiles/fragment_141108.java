driver.get("https://spicejet.com");
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    // click on search
    driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    // check from city error message
    if (driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText().equals("")) {
        if (driver.findElement(By.id("view-origin-station")).getText().equals("Select Departure City")) {
            System.out.println("Pass - Select Departure City message displayed as user did not enter from city.");
        }else {
            System.out.println("Fail - Select Departure City message not displayed when user not enter from city.");
        }
    }

    // enter from city
    driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
    driver.findElement(By.xpath("//a[contains(.,'ATQ')]")).click();
    // enter to city
    driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
    driver.findElement(By.xpath("//a[contains(.,'GOI')]")).click();