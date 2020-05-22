JSplitPane horizontal1 = new JSplitPane(
    JSplitPane.HORIZONTAL_SPLIT, yourCenterPanel, yourEastPanel);
JSplitPane horizontal2 = new JSplitPane(
    JSplitPane.HORIZONTAL_SPLIT, yourWestPanel, horizontal1);
JSplitPane vertical1 = new JSplitPane(
    JSplitPane.VERTICAL_SPLIT, horizontal2, yourSouthPanel);
JSplitPane vertical2 = new JSplitPane(
    JSplitPane.VERTICAL_SPLIT, yourNorthPanel, vertical1);
whateverPlaceYouWant.add(vertical2);