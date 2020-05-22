TouchAction touchAction = new TouchAction(driver);

    touchAction.longPress(PointOption.point(startx, starty))
               .moveTo(PointOption.point(endx, endy))
               .release()
               .perform();