private void layoutDividersAndContent(double width, double height) {
    final double paddingX = snappedLeftInset();
    final double paddingY = snappedTopInset();
    final double dividerWidth = contentDividers.isEmpty() ? 0 : contentDividers.get(0).prefWidth(-1);

    for (Content c: contentRegions) {
//        System.out.println("LAYOUT " + c.getId() + " PANELS X " + c.getX() + " Y " + c.getY() + " W " + (horizontal ? c.getArea() : width) + " H " + (horizontal ? height : c.getArea()));
        if (horizontal) {
            c.setClipSize(c.getArea(), height);
            layoutInArea(c, c.getX() + paddingX, c.getY() + paddingY, c.getArea(), height,
                0/*baseline*/,HPos.CENTER, VPos.CENTER);
        } else {
            c.setClipSize(width, c.getArea());
            layoutInArea(c, c.getX() + paddingX, c.getY() + paddingY, width, c.getArea(),
                0/*baseline*/,HPos.CENTER, VPos.CENTER);
        }
    }
    for (ContentDivider c: contentDividers) {
//        System.out.println("LAYOUT DIVIDERS X " + c.getX() + " Y " + c.getY() + " W " + (horizontal ? dividerWidth : width) + " H " + (horizontal ? height : dividerWidth));
        if (horizontal) {
            c.resize(dividerWidth, height);
            positionInArea(c, c.getX() + paddingX, c.getY() + paddingY, dividerWidth, height,
                /*baseline ignored*/0, HPos.CENTER, VPos.CENTER);
        } else {
            c.resize(width, dividerWidth);                
            positionInArea(c, c.getX() + paddingX, c.getY() + paddingY, width, dividerWidth,
                /*baseline ignored*/0, HPos.CENTER, VPos.CENTER);
        }
    }
}