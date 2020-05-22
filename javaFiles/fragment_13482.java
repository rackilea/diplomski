for (int i=0; i<items.size(); i++){
        driver.get(config.getProperty("URL"));

        //here goes your multiple user name
        usernameEditBox.sendKeys(items.get(i).trim());

        //here is your same password
        passwordEditBox.sendKeys(config.getProperty("Password"));

        signinButton.click();
        logout.click();
}