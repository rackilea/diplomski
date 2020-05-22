public class Example1 {

    public static void main(String args[]) {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("8/4/2012", new Day(8, 4, 2012).getFirstMillisecond());
        data.addValue("19/04/2012", new Day(19, 4, 2012).getFirstMillisecond());
        CategoryDataset dataset = DatasetUtilities
            .createCategoryDataset("Population", data);

        JFreeChart chart = ChartFactory.createLineChart("Population", "Date",
            "Population", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        renderer.setBaseLinesVisible(false);

        DateAxis range = new DateAxis("Date");
        range.setDateFormatOverride(new SimpleDateFormat("dd/MM/yyyy"));
        plot.setRangeAxis(range);

        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
    }
}