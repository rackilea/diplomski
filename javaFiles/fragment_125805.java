// If Outer most AnchorPane pref size is fixed then use it in this event
    // Else otherwise use the handleWindowShownEvent(WindowEvent event) 
    public void handleWindowShowingEvent(WindowEvent event) {
        Stage stage = (Stage) event.getSource();
        // Get X Y of start-up location on Active Screen
        StartUpLocation startUpLoc = new StartUpLocation(mainWindowAnchorPane.getPrefWidth(), mainWindowAnchorPane.getPrefHeight());
        double xPos = startUpLoc.getXPos();
        double yPos = startUpLoc.getYPos();
        // Set Only if X and Y are not zero and were computed correctly
        if (xPos != 0 && yPos != 0) {
            stage.setX(xPos);
            stage.setY(yPos);
        } else {
            stage.centerOnScreen();
        }
    }