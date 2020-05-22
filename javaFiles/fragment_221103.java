newDriver.get("https://twitter.com/");
    newDriver.findElement(By.name("session[username_or_email]")).sendKeys("arungnairktm@gmail.com");
    newDriver.findElement(By.name("session[password]")).sendKeys("Cisco_12345678");
    newDriver.findElement(By.className("submit")).click();
    WebElement composes = waits
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("global-new-tweet-button")));
    composes.click();
    WebElement tweets = waits.until(ExpectedConditions.visibilityOf(newDriver.findElement(By.cssSelector(
            "#Tweetstorm-tweet-box-0 > div.tweet-box-content > div.tweet-content > div.RichEditor.RichEditor--emojiPicker.is-fakeFocus > div.RichEditor-container.u-borderRadiusInherit > div.RichEditor-scrollContainer.u-borderRadiusInherit > div.tweet-box.rich-editor.is-showPlaceholder"))));

    tweets.click();
    tweets.sendKeys("heys");