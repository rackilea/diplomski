boolean displayed=false;

    try {
        mainPage.menu.isDisplayed();
        displayed=true;
    }catch (Exception e) {
        //element not displayed
        //displayed is false
    }

Assert.assertEquals(false, mainPage.menu.isDisplayed());