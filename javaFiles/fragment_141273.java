Actions actions = new Actions(driver);
    WebElement menuHoverLink = driver.findElement(By.linkText(arg1));

    //<span id="m7f8f3e49_ns_menu_INVENTOR_MODULE_a_tnode">Inventory</span>
    System.out.println("Found the inventory text");
    actions.moveToElement(menuHoverLink);
    actions.moveByOffset(100, 10);

    Thread.sleep(1000);
    //actions.moveByOffset(45, 0);
    WebElement subLink = driver.findElement(By.
            id("m7f8f3e49_ns_menu_INVENTOR_MODULE_sub_changeapp_SRVITEM_a_tnode"));
    actions.moveToElement(subLink, 100, 12)
    .click().perform();