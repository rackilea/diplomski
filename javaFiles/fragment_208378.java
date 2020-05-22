WebElement userName = findElementById("userName");
    userName.click();
    userName.clear();
    userName.sendKeys("testforUndo");

    WebElement undo = findElementById("cancel");
    undo.click();

    String text = findElementById("userName").getAttribute("value");
    String oldtext = "Testing";

    Assert.assertTrue(text.equals(oldtext));