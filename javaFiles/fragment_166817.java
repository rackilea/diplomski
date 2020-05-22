private void scrollDown() {
    //if pressX was zero it didn't work for me
    int pressX = driver.manage().window().getSize().width / 2;
    // 4/5 of the screen as the bottom finger-press point
    int bottomY = driver.manage().window().getSize().height * 4/5;
    // just non zero point, as it didn't scroll to zero normally
    int topY = driver.manage().window().getSize().height / 8;
    //scroll with TouchAction by itself
    scroll(pressX, bottomY, pressX, topY);
}

/*
 * don't forget that it's "natural scroll" where 
 * fromY is the point where you press the and toY where you release it
 */
private void scroll(int fromX, int fromY, int toX, int toY) {
    TouchAction touchAction = new TouchAction(driver);
    touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
}