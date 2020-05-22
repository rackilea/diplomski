import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.TableOrder;

/**
 * @see http://stackoverflow.com/a/17370398/230513
 * This example is similar to {@link MultiplePieChartDemo1}, but slices the
 * dataset by column rather than by row.
 */
public class MultiplePieChart extends JPanel {

    private JSlider slider = new JSlider();

    private CategoryDataset createDataset() {
        BigInteger topSources = new BigInteger("100");
        BigInteger notTopSources = new BigInteger("10");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(topSources, "Included Sources", "Sales Quantity");
        dataset.addValue(notTopSources, "Not Included Sources", "Sales Quantity");

        BigDecimal topSourcesTotal = new BigDecimal("1450.34");
        BigDecimal notTopSourcesTotal = new BigDecimal("99.78");
        dataset.addValue(topSourcesTotal, "Included Sources", "Sales Total");
        dataset.addValue(notTopSourcesTotal, "Not Included Sources", "Sales Total");

        return dataset;
    }

    private JFreeChart createChart() {
        final JFreeChart chart = ChartFactory.createMultiplePieChart(
            "Sales", createDataset(), TableOrder.BY_COLUMN, true, true, false);
        MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        final PiePlot p = (PiePlot) subchart.getPlot();
        p.setForegroundAlpha(0.5f);
        slider.setValue((int) (p.getForegroundAlpha() * 100));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                float value = (float) slider.getValue() / (float) 100;
                p.setForegroundAlpha(value);
                chart.fireChartChanged();
            }
        });
        return chart;
    }

    public JPanel createChartPanel() {
        JFreeChart chart = createChart();
        final ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 400);
            }
        };
        return chartPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MultiplePieChart mpc = new MultiplePieChart();
                JFrame frame = new JFrame();
                frame.add(mpc.createChartPanel());
                frame.add(mpc.slider, BorderLayout.SOUTH);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}