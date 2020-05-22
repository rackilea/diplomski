private AnchorPane addMapAnchor() {
    AnchorPane mapAnchor = new AnchorPane();
    ScrollPane mapScrollO = addMapScroll();
    mapAnchor.getChildren().add(mapScrollO);
    AnchorPane.setLeftAnchor(mapScrollO, 0.0);
    AnchorPane.setTopAnchor(mapScrollO, 0.0);
    AnchorPane.setBottomAnchor(mapScrollO, 0.0);
    AnchorPane.setRightAnchor(mapScrollO, 0.0);
    return mapAnchor;
}