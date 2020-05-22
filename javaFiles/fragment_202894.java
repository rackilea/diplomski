MyRenderer r = new MyRenderer(8);
XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), r);
JFreeChart chart = new JFreeChart(plot);
…
private static class MyRenderer extends XYLineAndShapeRenderer {

    private final int anchor;

    public MyRenderer(int acnchor) {
        this.anchor = acnchor;
    }

    @Override
    protected void drawPrimaryLine(XYItemRendererState state, Graphics2D g2,
        XYPlot plot, XYDataset dataset, int pass, int series, int item,
        ValueAxis domainAxis, ValueAxis rangeAxis, Rectangle2D dataArea) {
        if (item == anchor) {
            return;
        }
        …
        double x0 = dataset.getXValue(series, anchor);
        double y0 = dataset.getYValue(series, anchor);
        …
    }
}