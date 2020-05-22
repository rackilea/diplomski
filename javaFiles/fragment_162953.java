public class MyChartCustomizer implements JRChartCustomizer {

    @Override
    public void customize(JFreeChart jfchart, JRChart jrchart) {
        CategoryPlot plot = (CategoryPlot) jfchart.getPlot();
        //Set at what value you like the line, its color and size of stroke
        ValueMarker vm = new ValueMarker(13000,Color.BLUE, new BasicStroke(2.0F));
        //add marker to plot
        plot.addRangeMarker(vm);
    }
}