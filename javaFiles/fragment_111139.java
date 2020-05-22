Actions builder = new Actions(driver);
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        Action drag = builder.clickAndHold(element).moveToElement(target)
                .build();

        drag.perform();

        robot.keyPress(KeyEvent.VK_CONTROL);

        Action drop = builder.release().build();
        drop.perform();
        robot.keyRelease(KeyEvent.VK_CONTROL);