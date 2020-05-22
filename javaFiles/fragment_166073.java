import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import org.jfree.chart.*;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/** @See https://stackoverflow.com/q/44037591/230513 */
public class ChartPanelTest {

    private static final Random R = new Random();
    private static final int AGE = 60;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TimeSeriesCollection dataset = new TimeSeriesCollection();
            TimeSeries series1 = new TimeSeries("T1");
            series1.setMaximumItemAge(AGE);
            dataset.addSeries(series1);
            TimeSeries series2 = new TimeSeries("T2");
            series2.setMaximumItemAge(AGE);
            dataset.addSeries(series2);
            JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Test", "Time", "Value", dataset, false, false, false);
            ChartPanel chartPanel = new ChartPanel(chart) {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(640, 480);
                }
            };
            f.add(chartPanel);
            Timer timer = new Timer(2000, new ActionListener() {
                Second s = new Second();
                { for (int i = 0; i < AGE; i++) actionPerformed(null); }
                @Override
                public void actionPerformed(ActionEvent e) {
                    series1.add(s, R.nextGaussian());
                    series2.add(s, R.nextGaussian());
                    s = (Second) s.next().next();
                }
            });
            timer.start();
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}