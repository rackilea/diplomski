public class TSChartCustomizer extends JRAbstractChartCustomizer {
    public void customize(JFreeChart chart, JRChart jasperChart) {
        AbstractCategoryItemRenderer renderer = (AbstractCategoryItemRenderer) chart.getCategoryPlot().getRenderer();
        BasicStroke stroke = new BasicStroke(3f);
        renderer.setSeriesStroke(0, stroke);
    }
}