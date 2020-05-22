public static class MyLineChart<X, Y> extends LineChart<X, Y> {

    public MyLineChart(Axis<X> xAxis, Axis<Y> yAxis) {
        super(xAxis, yAxis);
    }

    private TilePane legendAlias;
    private FlowPane legendReplacement;

    @Override
    protected void updateLegend() {

        // let super do the setup
        super.updateLegend();
        Node legend = getLegend();
        if (legend instanceof TilePane) {
            legendAlias = (TilePane) legend;
            legendReplacement = new FlowPane(10, 10);
            setLegend(legendReplacement);
        }
        if (legendAlias != null && legendAlias.getChildren().size() > 0) {
            legendReplacement.getChildren().setAll(legendAlias.getChildren());
            legendAlias.getChildren().clear();
            setLegend(legendReplacement);
        }
    }

}