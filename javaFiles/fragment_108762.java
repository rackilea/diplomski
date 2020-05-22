new TouchAction(driver)
            .press(mobileElement)
            .waitAction(300)
            .moveTo(0,100)
            .release()
            .perform();