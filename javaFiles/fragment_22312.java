int MAX_PAGES = 3;
    driver.get("https://yahoo.com");
    driver.findElement(By.id("uh-search-box")).sendKeys("hotmail");
    driver.findElement(By.id("uh-search-button")).click();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    for (int i = 0; i < MAX_PAGES; i++) {
        for (WebElement link : driver.findElements(By.cssSelector("h3.title > a"))) {
            System.out.println("Title: " + link.getText() + " link" + link.getAttribute("href"));
        }
        driver.findElement(By.className("next")).click();
    }