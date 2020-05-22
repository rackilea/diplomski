import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.NumberFormat;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;

/**
 * @see https://stackoverflow.com/a/38080778/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultStatisticalCategoryDataset dataset
            = new DefaultStatisticalCategoryDataset();
        dataset.add(1, 0.1, "series", "A");
        dataset.add(2, 0.4, "series", "B");
        dataset.add(2, 0.2, "series", "C");

        CategoryAxis domain = new CategoryAxis();
        ValueAxis range = new NumberAxis();
        StatisticalLineAndShapeRenderer renderer
            = new StatisticalLineAndShapeRenderer(true, true);
        CategoryPlot plot = new CategoryPlot(dataset, domain, range, renderer);
        JFreeChart chart = new JFreeChart(
            "ErrorBars", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        renderer.setBaseItemLabelGenerator(
            new StandardCategoryItemLabelGenerator("{2}",
                NumberFormat.getNumberInstance()));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setSeriesShape(0, new Rectangle2D.Double(0, 0, 0, 0));
        new StandardChartTheme("JFree").apply(chart);
        f.add(new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 300);
            }
        });

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}