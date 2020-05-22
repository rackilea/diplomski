import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class ChartPanelTest {

    private static final int N = 16;
    private static final Random random = new Random();

    private static XYDataset createDataset() {
        TimeSeriesCollection tsc = new TimeSeriesCollection();
        for (int j = 0; j < N; j++) {
            TimeSeries series = new TimeSeries("Data" + j);
            Day current = new Day();
            for (int i = 0; i < N * N; i++) {
                series.add(current, random.nextGaussian());
                current = (Day) current.next();
            }
            tsc.addSeries(series);
        }
        return tsc;
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Test", "Day", "Value", dataset, false, false, false);
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
                final XYPlot plot = chart.getXYPlot();
                ChartPanel chartPanel = new ChartPanel(chart) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 300);
                    }
                };
                f.add(chartPanel);
                JPanel p = new JPanel();
                p.add(new JButton(new AbstractAction("New") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        plot.setDataset(createDataset());
                    }
                }));
                f.add(p, BorderLayout.SOUTH);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}