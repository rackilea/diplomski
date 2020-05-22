Boolean elementNotVisible;
    List<WebElement> elements = driver.findElements(By.xpath(xMaterialNumber));
    if (elements.isEmpty()) {
        elementNotVisible = true;
    } else {
        elementNotVisible = true;
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                elementNotVisible = false;
                break;
            }
        }
    }
    if (elementNotVisible) {
        m.click(xCloseOrder);
        m.click(xOpenOrderRequest);
        m.click(xOpenOrderImport);
    }