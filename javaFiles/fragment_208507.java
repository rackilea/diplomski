import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;

/**
 * @see https://stackoverflow.com/a/38906326/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Demo d = new Demo();
        ChartPanel cp = d.buildDialPlot(0, 100, 10);
        f.add(cp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class Demo {

        private DefaultValueDataset dataset = new DefaultValueDataset(0);

        private ChartPanel buildDialPlot(int minimumValue, int maximumValue, int majorTickGap) {

            DialPlot plot = new DialPlot(dataset);
            plot.setDialFrame(new StandardDialFrame());
            plot.addLayer(new DialValueIndicator(0));
            plot.addLayer(new DialPointer.Pointer());
            int redLine = maximumValue / 5 + 10;
            plot.addLayer(new StandardDialRange(maximumValue, redLine, Color.blue));
            plot.addLayer(new StandardDialRange(redLine, minimumValue, Color.red));

            StandardDialScale scale = new StandardDialScale(minimumValue,
                maximumValue, -120, -300, majorTickGap, majorTickGap - 1);
            scale.setTickRadius(0.88);
            scale.setTickLabelOffset(0.20);
            scale.setTickLabelsVisible(false);
            plot.addScale(0, scale);

            return new ChartPanel(new JFreeChart(plot)) {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(300, 300);
                }
            };
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}