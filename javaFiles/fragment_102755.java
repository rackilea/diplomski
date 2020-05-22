import java.awt.EventQueue;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.*;
import java.awt.event.*;

public class Graph extends ApplicationFrame {

    private final TimeSeries seriesA = new TimeSeries("A");
    private final TimeSeries seriesB = new TimeSeries("B");

    public Graph(final String windowTitle, int width, int height,
        String xTitle, String yTitle, String headerTitle, String graphTitle) {
        super(windowTitle);
        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(this.seriesA);
        dataset.addSeries(this.seriesB);
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            headerTitle, xTitle, yTitle, dataset, true, true, false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(width, height));
        add(chartPanel);
    }

    public void addPointA(double y) {
        this.seriesA.add(new Millisecond(), y);
    }

    public void addPointB(double y) {
        this.seriesB.add(new Millisecond(), y);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            Graph demo = new Graph("Demo", 640, 480,
                "Time", "Value", "Header", "Graph");
            demo.pack();//matters a great deal
            RefineryUtilities.centerFrameOnScreen(demo);
            demo.setVisible(true);

            new Timer(100, (new ActionListener() {
                double lastValue = 80;

                @Override
                public void actionPerformed(ActionEvent e) {
                    demo.addPointA(lastValue);
                    demo.addPointB(lastValue - 100);
                    lastValue *= Math.random() * 0.2 - 0.1 + 1.001;
                    lastValue += Math.random() * 2 - 1;
                }
            })).start();
        });
    }
}