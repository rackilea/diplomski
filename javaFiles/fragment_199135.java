public static  void selectOption(WebDriver driver, String optionName) {
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='selectize-dropdoun-content']//div[@class='option']"));
        options.forEach(option -> {
            if (option.getAttribute("innerText").equals(optionName)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(option).click().build().perform();
            }
        });
    }