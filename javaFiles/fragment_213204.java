public void userLogout(){ // and then you can use explicitWait() in this method
    SatusPageElements forLogOut = new SatusPageElements();
        if(driver != null) {
            UtilsClass uc = new UtilsClass(); // create instance of class where explicitWait()
            uc.explicitWait().until(ExpectedConditions.elementToBeClickable(forLogOut.profileName))
            driver.findElement(forLogOut.profileName).click();
            uc.explicitWait().until(ExpectedConditions.elementToBeClickable(forLogOut.logoutLink))
            driver.findElement(forLogOut.logoutLink).click();
        } else{

        System.out.println("No Driver");