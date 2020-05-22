import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/a/36757609/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final ChartPanel chartPanel = new ChartPanel(null);
        f.add(chartPanel);
        f.add(new JButton(new AbstractAction("Draw Graph") {
            @Override
            public void actionPerformed(ActionEvent e) {
                chartPanel.setChart(
                    new XYLineChartAWT().runGraph("Title", "X", "Y"));
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}

public class XYLineChartAWT {

    public JFreeChart runGraph(String chartTitle, String xLabel, String yLabel) {
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
            chartTitle,
            xLabel,
            yLabel,
            createDataset(),
            PlotOrientation.VERTICAL,
            true, false, false);
        final XYPlot plot = xylineChart.getXYPlot();
        plot.setBackgroundPaint(new Color(240, 240, 240));
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        plot.setRenderer(renderer);
        return xylineChart;
    }

    private XYDataset createDataset() {
        final XYSeries seno = new XYSeries("Sin");
        for (double i = 0; i <= 1440; i++) {
            double temp = Math.sin(i * ((2 * Math.PI) / 640) + Math.PI) + 1;
            seno.add(i / 60, temp);
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seno);
        return dataset;
    }
}