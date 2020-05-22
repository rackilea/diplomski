import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/** @see http://stackoverflow.com/a/12607586/230513 */
public class PolarCharDemo {

    private static final String title = "PolarChart";
    private static final double START = 0;
    private static final double END = 145;

    private void display() {
        JFrame f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel panel = new ChartPanel(createChart(createDataset()));
        panel.setPreferredSize(new Dimension(500, 500));
        f.add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createPolarChart(
            title, dataset, true, false, false);
        PolarPlot plot = (PolarPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setAngleGridlinePaint(Color.black);
        plot.setRadiusGridlinePaint(Color.lightGray);
        DefaultPolarItemRenderer r = (DefaultPolarItemRenderer) plot.getRenderer();
        r.setFillComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        for (int i = 0; i < dataset.getSeriesCount(); i++ ) {
            r.setSeriesFilled(i, true);
            r.setShapesVisible(false);
            r.setDrawOutlineWhenFilled(false);
        }
        NumberAxis rangeAxis = (NumberAxis) plot.getAxis();
        rangeAxis.setTickLabelsVisible(false);
        return chart;
    }

    private XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        for (int r = 4; r > 0; r--) {
            XYSeries series = new XYSeries(title + String.valueOf(r));
            series.add(0, 0);
            for (int t = (int) START; t <= END; t++) {
                series.add(t, r);
            }
            result.addSeries(series);
        }
        return result;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PolarCharDemo().display();
            }
        });
    }
}