private WebElement findElementIfPresent(WebDriver driver, By by){
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    ...

    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).submit();

    // obtain the div which holds the information
    WebElement errorDiv = findElementIfPresent(driver, By.xpath("//div[@class='errorMsg']"));


    // if the div exists and it has an authentication-problem messages, fail
    if(errorDiv != null && errorDiv.getText().matches("Username or password incorrect. Try again."))
        fail("Username Or Password is Incorrect.");
    }

    // otherwise proceed with additional verifications
    assertEquals(actualTitle, title,"Home is not accessible!");