public static void assertContains(WebElement outerElem, WebElement innerElem) {
    // get borders of outer element
    Point outerLoc = outerElem.getLocation();
    Dimension outerDim = outerElem.getSize();
    int outerLeftX = outerLoc.getX();
    int outerRightX = outerLeftX + outerDim.getWidth();
    int outerTopY = outerLoc.getY();
    int outerBottomY = outerTopY + outerDim.getHeight();

    // get borders of inner element
    Point innerLoc = innerElem.getLocation();
    Dimension innerDim = innerElem.getSize();
    int innerLeftX = innerLoc.getX();
    int innerRightX = innerLeftX + innerDim.getWidth();
    int innerTopY = innerLoc.getY();
    int innerBottomY = innerTopY + innerDim.getHeight();

    // assures the inner borders don't cross the outer borders
    final String errorMsg = "ughh, some error message";
    final boolean contains = (outerLeftX <= innerLeftX)
            && (innerRightX <= outerRightX)
            && (outerTopY <= innerTopY)
            && (innerBottomY <= outerBottomY);
    assertTrue(errorMsg, contains);
}