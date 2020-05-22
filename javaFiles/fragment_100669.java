WebDriver driver = new FirefoxDriver(firefoxOptions);
        try {
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_canvas_empty");
            WebElement iframe = driver.findElement(By.name("iframeResult"));
            driver.switchTo().frame(iframe);
            WebElement canvas = driver.findElement(By.id("myCanvas"));
            System.out.println(canvas.getText());
        } finally {
            driver.quit();
        }