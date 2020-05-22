String mainWindow = driver.getWindowHandle();
        Set<String> windows= driver.getWindowHandles();
        if (windows.size() > 1) {
            //first remove main window
            windows.remove(mainWindow);
            //switching to new/child window and perform some action on new window if required. Then close it.
            driver.switchTo().window(windows.iterator().next());
            driver.close();
            //switching back to mainWindow, Then continue with your actions.
            driver.switchTo().window(mainWindow);
            windows.clear();
        }