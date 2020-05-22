public void exampleInputRadio(WebDriver driver, int option) {
        List<WebElement> radios = driver.findElements(By.name("exampleInputRadio"));
        if (option > 0 && option <= radios.size()) {
            radios.get(option - 1).click();
        } else {
            throw new NotFoundException("option " + option + " not found");
        }
    }