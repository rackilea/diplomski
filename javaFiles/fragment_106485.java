//Click on browse file button, open a popup
    selenium.click("//input[@value='Browse...']");

    //waiting for popup to load
    selenium.waitForPopUp("_Dialog", "30000");

    //selecting the popup by passing window name
    selenium.selectWindow("name=_Dialog");

    //click a link inside pop up window
    selenium.click("link=something");

    //Put other popup operations here

    //click cancel button for pop up
    selenium.click("cancel");

    //back to main window
    selenium.selectwindow("null")