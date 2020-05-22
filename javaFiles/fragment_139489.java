driver.get("http://sssamriddhisales.com/crm");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(3, TimeUnit.MINUTES).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        WebElement userName = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("userName"));
            }
        });
        WebElement password = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("password"));
            }
        });
        WebElement submit = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@type='submit']"));
            }
        });

        userName.sendKeys("admin");
        password.sendKeys("admin123");     
        submit.click();

        WebElement settings = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//a[@class='text-center']//span[text()='Settings']"));
            }
        });
        Actions actions = new Actions(driver);
        actions.moveToElement(settings).build().perform();

        final WebElement element = driver.findElement(By.xpath("//li[@data-id='area']//a[text()='Area']"));
        WebElement area = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        area.click();