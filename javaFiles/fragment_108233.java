public class BarExample {
    public static void main(String arg[]) throws IOException {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(2, Integer.valueOf(1), Integer.valueOf(5));
        dataSet.setValue(7, Integer.valueOf(1), Integer.valueOf(10));
        dataSet.setValue(4, Integer.valueOf(1), Integer.valueOf(15));
        dataSet.setValue(9, Integer.valueOf(1), Integer.valueOf(20));
        dataSet.setValue(6, Integer.valueOf(1), Integer.valueOf(25));
        JFreeChart chart = ChartFactory.createBarChart
                ("Chart", "Number of Days", "Number of ECR", dataSet,
                        PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        // Reduce margin between bars
        plot.getDomainAxis().setCategoryMargin(0.0);
        // Reduce left and right margin
        plot.getDomainAxis().setLowerMargin(0.0);
        plot.getDomainAxis().setUpperMargin(0.0);
        FileOutputStream outputStream = new FileOutputStream(
                new File("chart.png"));
        ChartUtilities.writeChartAsPNG(outputStream, chart, 1024, 768);
    }
}