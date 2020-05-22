import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

/**
 * @see https://stackoverflow.com/a/38407595/230513
 */
public class BoxPlot {


    private void display() {
        JFrame f = new JFrame("BoxPlot");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultBoxAndWhiskerCategoryDataset data = new DefaultBoxAndWhiskerCategoryDataset();
        data.add(Arrays.asList(30, 36, 46, 55, 65, 76, 81, 80, 71, 59, 44, 34), "Planet", "Endor");
        JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
            "Box and Whisker Chart", "Planet", "Temperature", data, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        f.add(new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 300);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new BoxPlot()::display);
    }
}