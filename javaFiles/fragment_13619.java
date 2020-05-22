if (scaleFactor * SCALE_TOTAL >= 1) {
    Bounds viewPort = mapScroll.getViewportBounds();
    Bounds contentSize = mapViewO.getBoundsInParent();

    double centerPosX = (contentSize.getWidth() - viewPort.getWidth()) * mapScroll.getHvalue() + viewPort.getWidth() / 2;
    double centerPosY = (contentSize.getHeight() - viewPort.getHeight()) * mapScroll.getVvalue() + viewPort.getHeight() / 2;

    mapViewO.setScaleX(mapViewO.getScaleX() * scaleFactor);
    mapViewO.setScaleY(mapViewO.getScaleY() * scaleFactor);
    SCALE_TOTAL *= scaleFactor;

    double newCenterX = centerPosX * scaleFactor;
    double newCenterY = centerPosY * scaleFactor;

    mapScroll.setHvalue((newCenterX - viewPort.getWidth()/2) / (contentSize.getWidth() * scaleFactor - viewPort.getWidth()));
    mapScroll.setVvalue((newCenterY - viewPort.getHeight()/2) / (contentSize.getHeight() * scaleFactor  -viewPort.getHeight()));
}