public boolean checkIfElementIsExpanded(int number) {
        WebElement textElement = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[2]")));
        return textElement.isDisplayed();
    }


    public void collapseAnItem(int number) {
        WebElement itemHeader = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[1]/h4/a")));
        if (checkIfElementIsExpanded(number)) {
            itemHeader.click();
        }

        // Since you collapsing item, text will become invisible, so we need to wait for invisibility
        WebElement textElement = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[2]")));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOf(textElement));
    }


    public void expandAnItem(int number) {
        WebElement itemHeader = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[1]/h4/a")));
        if (!checkIfElementIsExpanded(number)) {
            itemHeader.click();
        }

        // Since you collapsing item, text will become visible, so we need to wait for visibility
        WebElement textElement = driver.findElement(By.xpath(("//*[@id='accordion']/div[" + number + "]/div[2]")));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(textElement));
    }