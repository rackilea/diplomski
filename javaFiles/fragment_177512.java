if (operation.equalsIgnoreCase("newTab")) {
        System.out.println("newTab" + temp);
        Actions newTab = new Actions(driver);
        newTab.keyDown(Keys.COMMAND).click(temp).keyUp(Keys.COMMAND).build().perform();

        // Do your switch windows and other stuff you plan here after opening the new tab

    }