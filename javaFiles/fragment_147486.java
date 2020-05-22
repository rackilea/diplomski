dateNumberData.getNode().setOnMouseEntered(event -> {

    Bounds bounds = dateNumberData.getNode().localToScreen(dateNumberData.getNode().getBoundsInLocal());
    tooltip.show(dateNumberData.getNode(),
        bounds.getMaxX()+15,
        bounds.getMaxY()+5);
    });