import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;

/**
 * @see https://stackoverflow.com/a/40167139/230513
 */
public class TestDistribution {

    private static class JFreeChartPanel extends JPanel {

        private XYPlot plot;
        private double mean = 0.0, sigma = 1.0;
        XYDataset dataset = initDataset();

        private XYDataset initDataset() {
            Function2D normal = new NormalDistributionFunction2D(mean, sigma);
            XYDataset dataset = DatasetUtilities.sampleFunction2D(normal, -5.0, 5.0, 100, "Normal");
            return dataset;
        }

        ;
        public double getMean() {
            return mean;
        }

        public void setMean(double mean) {
            this.mean = mean;
            plot.setDataset(initDataset());
        }

        public double getStd() {
            return sigma;
        }

        public void setStd(double sigma) {
            this.sigma = sigma;
        }

        public JFreeChartPanel() {
            JFreeChart chart = ChartFactory.createXYLineChart(
                "Normal Distribution", "X", "Y", dataset,
                PlotOrientation.VERTICAL, true, true, false
            );
            plot = chart.getXYPlot();
            final ChartPanel chartPanel = new ChartPanel(chart);
            add(chartPanel);
        }
    }

    private void display() {
        JFrame f = new JFrame("TestDistribution");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFreeChartPanel chartPanel = new JFreeChartPanel();
        f.add(chartPanel);
        JSpinner spinner = new JSpinner();
        spinner.setValue(chartPanel.mean);
        spinner.addChangeListener((ChangeEvent e) -> {
            JSpinner s = (JSpinner) e.getSource();
            Number n = (Number) s.getValue();
            chartPanel.setMean(n.doubleValue());
        });
        f.add(spinner, BorderLayout.PAGE_END);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TestDistribution()::display);
    }
}