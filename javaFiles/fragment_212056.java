//Name of the state to select.
    String stateName = "AL - Alabama";

    //Open Url.
    driver.get("https://tools.usps.com/go/ZipLookupAction!input.action");

    //Click on state select box, which makes the list visible.
    driver.findElement(By.className("select-current-text")).click();

    //Select the state from the list.
    driver.findElement(By.partialLinkText(stateName)).click();