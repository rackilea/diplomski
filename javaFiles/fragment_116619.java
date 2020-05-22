List<WebElement> alldates = driver.findElements(by.id('locator of the date picker which conatins all dates in it'));
    for (WebElement dates : alldates) {
                    if (dates.isDisplayed() && dates.isEnabled()
                            && dates.getText().equalsIgnoreCase("Date To be Clicked")) {
                        dates.click();
                    }
                }