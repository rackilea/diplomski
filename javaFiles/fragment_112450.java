public class MyChartCustomizer implements JRChartCustomizer {
    @Override
    public void customize(JFreeChart jFreeChart, JRChart jRChart) {
        ((XYPlot)jFreeChart.getPlot()).setRenderer(new XYSplineRenderer());
    }
}