chart.addCustomizer(new DRIChartCustomizer() {      
    private static final long serialVersionUID = 1L;
    @Override
    public void customize(JFreeChart chart, ReportParameters arg1) {
        CategoryPlot plot = (CategoryPlot) jfchart.getPlot();
        ValueMarker vm = new ValueMarker(13000,Color.BLUE, new BasicStroke(2.0F));
        plot.addRangeMarker(vm);
    }
});