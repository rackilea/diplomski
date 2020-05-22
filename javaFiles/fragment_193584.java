import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartTester extends JFrame {

    private static final long serialVersionUID = 1L;

    public ChartTester(final String title) {
        super(title);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Returns a sample dataset.
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        final String rowName = "Row";
        final String[] columnName = { "Column1","Column2","Column3","Column4","Column5"};
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(9.2, rowName, columnName[0]);
        dataset.addValue(9.3, rowName, columnName[1]);
        dataset.addValue(9.4, rowName, columnName[2]);
        dataset.addValue(9.5, rowName, columnName[3]);
        dataset.addValue(10.0, rowName, columnName[4]);

        return dataset;
    }

    /**
     * Creates a sample chart.
     * @param dataset  the dataset.
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        double d =9.0;
        final JFreeChart chart =
            ChartFactory.createBarChart(
                    "Chart Title",
                    "X Axis",
                    "Y Axis",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
        chart.setBackgroundPaint(Color.white);  
        // Set the background color of the chart
        chart.getTitle().setPaint(Color.DARK_GRAY);
        chart.setBorderVisible(true);
        // Adjust the color of the title
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRangeAxis().setLowerBound(d);
        // Get the Plot object for a bar graph
        plot.setBackgroundPaint(Color.white);     
        plot.setRangeGridlinePaint(Color.blue);
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.decode("#00008B"));
        return chart;
    }

    public static void main(final String[] args) {
        final ChartTester test = new ChartTester("Test");
        test.pack();
        test.setVisible(true);
    }
}