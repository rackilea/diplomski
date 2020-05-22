/**
 * This is called whenever a series is added or removed and the legend needs to be updated
 */
@Override protected void updateLegend() {
    legend.getItems().clear();
    if (getData() != null) {
        for (int seriesIndex=0; seriesIndex< getData().size(); seriesIndex++) {
            Series<X,Y> series = getData().get(seriesIndex);
            LegendItem legenditem = new LegendItem(series.getName());
            if (!series.getData().isEmpty() && series.getData().get(0).getNode() != null) {
                legenditem.getSymbol().getStyleClass().addAll(series.getData().get(0).getNode().getStyleClass());
            }
            legend.getItems().add(legenditem);
        }
    }
    if (legend.getItems().size() > 0) {
        if (getLegend() == null) {
            setLegend(legend);
        }
    } else {
        setLegend(null);
    }
}