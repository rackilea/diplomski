if (System.getProperty("browser").equals("ie")) {
        try {
            Robot robot = new Robot();
            //...
            //Rest of the robot code
            //...
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    } else {
        textField.clear();
        textField.sendKeys(textStr);
    }