public void drawAxis() {
    int i = 0;
    for(i=0; i<20; i++) {
        double y_pos = i*100;
        Line gridTick = new Line(0, y_pos, 20, y_pos);

        Label gridLabel = new Label(getStringFromValue(y_pos));
        gridLabel.setLayoutX(30);

        // make sure label bounds range from y_pos-25 to y_pos+25 vertically
        gridLabel.setLayoutY(y_pos-25);
        gridLabel.setPrefHeight(2*25);
        gridLabel.setMinHeight(Region.USE_PREF_SIZE);
        // set text alignment in label area
        gridLabel.setAlignment(Pos.CENTER_LEFT);

        rightAxisPanel.getChildren().addAll(gridTick, gridLabel);
    }
}