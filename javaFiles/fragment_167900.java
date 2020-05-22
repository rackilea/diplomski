barchart.getData().addAll(series1);

if (bluebutton.isSelected()) {
    barchart.lookupAll(".default-color0.chart-bar")
            .forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
}