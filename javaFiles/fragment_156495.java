MeterPlot meterplot = new MeterPlot(valuedataset) {

    @Override
    public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info) {
        double h = area.getHeight() * 6 / 5;
        area.setRect(area.getX(), area.getY(), area.getWidth(), h);
        super.draw(g2, area, anchor, parentState, info);
    }
};