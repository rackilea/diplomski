private void showChartData() {
    for (Series<String, Number> s : olChartData) {
        for (Data d : s.getData()) {
            StackPane sp = (StackPane) d.getNode();
            Label l = new Label(String.valueOf(Math.round((double) d.YValueProperty().getValue())));
            l.setStyle("-fx-font-size: 10;");
            l.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
            sp.getChildren().add(l);
            sp.toFront();
            sp.setCursor(Cursor.TEXT);
        }
    }