for (int i=0; i < continuereading.size(); i++){
    //open link in new tab
            Actions action = new Actions(driver);
            action.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.LEFT_SHIFT).perform();
            //scroll to the element 
            jse.executeScript("arguments[0].scrollIntoView(true);", continuereading.get(i));
            continuereading.get(i).click();
            action.keyUp(Keys.LEFT_CONTROL).keyDown(Keys.LEFT_SHIFT).perform();

            //close new tab
            action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0077')).perform();
            action.keyUp(Keys.CONTROL).sendKeys(String.valueOf('\u0077')).perform();

        }