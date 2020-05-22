public class SO{
public static void main(String[] args) {

    // Create a simple XY chart
    XYSeries series = new XYSeries("Gradient logs chopped");
    series.add(1, -7);
    series.add(2, -2);
    series.add(3, 4);
    series.add(4, 7);
    series.add(5, 10);
    // Add the series to your data set
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);
    // Generate the graph
    JFreeChart chart = ChartFactory.createXYLineChart(
    "Logs chopped", // Title
    "Week", // x-axis Label
    "Logs", // y-axis Label
    dataset, // Dataset
    PlotOrientation.VERTICAL, // Plot Orientation
    true, // Show Legend
    true, // Use tooltips
    false // Configure chart to generate URLs?
    );

    //The renderer part
    XYPlot plot = chart.getXYPlot(); 
    XYDifferenceRenderer rend = new XYDifferenceRenderer(Color.GREEN, Color.RED, false);
    rend.setSeriesFillPaint(0, Color.DARK_GRAY);
    rend.setRoundXCoordinates(true);
    plot.setRenderer(rend);
    //The renderer part


    try {
    ChartUtilities.saveChartAsJPEG(new File("D:\\Users\\user2777005\\Desktop\\XYchart.jpg"), chart, 500, 300);
    } catch (IOException e) {
    System.err.println("Problem occurred creating chart.");
    }
   }
}