//zoom in the image
MultiTouchAction multiTouch = new MultiTouchAction(driver);
TouchAction action0 = new TouchAction(driver).press(xpos1, ypos1).moveTo(-45,-45).release();
TouchAction action1 = new TouchAction(driver).press(xpos2, ypos2).moveTo(45,45).release();
multiTouch.add(action0).add(action1).perform();

//for zoom in, point used in moveTo() is same but opposite direction