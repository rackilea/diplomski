import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/** @see https://stackoverflow.com/a/21953170/230513 */
public class ChartPanelXYTest {

    private static final Random random = new Random();

    private static XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        File[] files = new File(System.getProperty("user.dir")).listFiles();
        for (File f : files) {
            XYSeries series = new XYSeries("f" + f.hashCode());
            for (int i = 0; i < f.getName().length(); i++) {
                series.add(i, random.nextGaussian());
            }
            dataset.addSeries(series);
        }
        return dataset;
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Test", "Domain",
            "Range", dataset, PlotOrientation.VERTICAL, true, false, false);
        return chart;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                XYDataset dataset = createDataset();
                JFreeChart chart = createChart(dataset);
                ChartPanel chartPanel = new ChartPanel(chart) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(640, 480);
                    }
                };
                f.add(chartPanel);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}