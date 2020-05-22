LineChart<Number, Number> chart;

for (Node n : chart.getChildrenUnmodifiable()) {
    if (n instanceof Legend) {
        Legend l = (Legend) n;
        for (Legend.LegendItem li : l.getItems()) {
            for (XYChart.Series<Number, Number> s : chart.getData()) {
                if (s.getName().equals(li.getText())) {
                    li.getSymbol().setCursor(Cursor.HAND); // Hint user that legend symbol is clickable
                    li.getSymbol().setOnMouseClicked(me -> {
                        if (me.getButton() == MouseButton.PRIMARY) {
                            s.getNode().setVisible(!s.getNode().isVisible()); // Toggle visibility of line
                            for (XYChart.Data<Number, Number> d : s.getData()) {
                                if (d.getNode() != null) {
                                    d.getNode().setVisible(s.getNode().isVisible()); // Toggle visibility of every node in the series
                                }
                            }
                        }
                    });
                    break;
                }
            }
        }
    }
}