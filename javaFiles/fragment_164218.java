WebDriver driver= new FirefoxDriver();
            driver.get("https://www.google.co.in");
            driver.manage().window().maximize();
            WebElement searchbox= driver.findElement(By.id("lst-ib"));
            searchbox.sendKeys("gmail");
            driver.findElement(By.name("btnG")).click();
          driver.findElement(By.xpath("//ol[@id='rso']/div[1]/div[1]/div/h3/a")).click();