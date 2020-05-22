String adminWindow = driver.getWindowHandle();

    System.out.println(adminWindow);

    ClickBuissness.click();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    Set<String> allWindows = driver.getWindowHandles();

    String agentWindow = null;

    int count =allWindows.size();

    System.out.println("Total window"  + count);

    for(String windowHandle : allWindows){

        if (!windowHandle.equals(adminWindow))

            agentWindow=windowHandle;
    }
        driver.switchTo().window(agentWindow);


        }