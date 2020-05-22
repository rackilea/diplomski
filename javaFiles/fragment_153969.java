import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;

/** @see http://stackoverflow.com/questions/7597015 */
public class ThermometerDemo extends JPanel {

    private static final int W = 200;
    private static final int H = 2 * W;

    public ThermometerDemo(double value) {
        this.setLayout(new GridLayout());
        DefaultValueDataset dataset = new DefaultValueDataset(value);
        ThermometerPlot plot = new ThermometerPlot(dataset);
        plot.setSubrangePaint(0, Color.green.darker());
        plot.setSubrangePaint(1, Color.orange);
        plot.setSubrangePaint(2, Color.red.darker());
        JFreeChart chart = new JFreeChart("Demo",
            JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        this.add(new ChartPanel(chart, W, H, W, H, W, H,
            false, true, true, true, true, true));
    }

    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Demo");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLayout(new GridLayout(1, 0));
                f.add(new ThermometerDemo(40));
                f.add(new ThermometerDemo(60));
                f.add(new ThermometerDemo(80));
                f.pack();
                f.setVisible(true);
            }
        });

    }
}