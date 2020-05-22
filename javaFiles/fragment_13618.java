private ScrollPane addMapScroll() {
    ScrollPane mapScroll = new ScrollPane();
    ImageView mapViewO = addMapView();
    mapScroll.setContent(new Group(mapViewO));
    mapScroll.setPannable(true);
    mapScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
    mapScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
    mapScroll.addEventFilter(ScrollEvent.ANY, e -> {
        e.consume();
        if (e.getDeltaY() == 0) {
            return;
        }
        double scaleFactor
                = (e.getDeltaY() > 0)
                        ? SCALE_DELTA
                        : 1 / SCALE_DELTA;

        if (scaleFactor * SCALE_TOTAL >= 1) {
            mapViewO.setScaleX(mapViewO.getScaleX() * scaleFactor);
            mapViewO.setScaleY(mapViewO.getScaleY() * scaleFactor);
            SCALE_TOTAL *= scaleFactor;
        }
    });
    return mapScroll;
}