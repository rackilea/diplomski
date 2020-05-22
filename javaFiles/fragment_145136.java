import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Shape;
import java.util.*;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

/**
 * @see http://stackoverflow.com/a/20359200/230513
 * @see http://stackoverflow.com/a/6669529/230513
 */
public class ScatterShape extends JFrame {

    private static final int N = 8;
    private static final int SIZE = 345;
    private static final String title = "Scatter Shape Demo";
    private static final Random rand = new Random();
    private final XYSeries series = new XYSeries("Data");

    public ScatterShape(String s) {
        super(s);
        final ChartPanel chartPanel = createDemoPanel();
        this.add(chartPanel, BorderLayout.CENTER);
    }

    private ChartPanel createDemoPanel() {
        JFreeChart chart = ChartFactory.createScatterPlot(
            title, "X", "Y", createSampleData(),
            PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) chart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        xyPlot.setRenderer(new XYLineAndShapeRenderer(false, true) {

            @Override
            public Shape getItemShape(int row, int col) {
                if (row == 0 & col == N) {
                    return ShapeUtilities.createDiagonalCross(5, 2);
                } else {
                    return super.getItemShape(row, col);
                }
            }
        });
        adjustAxis((NumberAxis) xyPlot.getDomainAxis(), true);
        adjustAxis((NumberAxis) xyPlot.getRangeAxis(), false);
        xyPlot.setBackgroundPaint(Color.white);
        return new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(SIZE, SIZE);
            }
        };
    }

    private void adjustAxis(NumberAxis axis, boolean vertical) {
        axis.setRange(-3.0, 3.0);
        axis.setTickUnit(new NumberTickUnit(0.5));
        axis.setVerticalTickLabels(vertical);
    }

    private XYDataset createSampleData() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        for (int i = 0; i < N * N; i++) {
            series.add(rand.nextGaussian(), rand.nextGaussian());
        }
        xySeriesCollection.addSeries(series);
        return xySeriesCollection;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ScatterShape demo = new ScatterShape(title);
                demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                demo.pack();
                demo.setLocationRelativeTo(null);
                demo.setVisible(true);
            }
        });
    }
}