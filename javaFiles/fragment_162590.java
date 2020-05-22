import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.GeneralPath;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/q/59588078/230513
 * @see http://stackoverflow.com/a/35236100/261156
 */
public class AnnotationTest {

    private static final BasicStroke STROKE = new BasicStroke(2.0f);
    private static final int N = 16;
    private static final int W = 1;
    private static final int H = W;

    public static void main(String[] args) {
        EventQueue.invokeLater(new AnnotationTest()::display);
    }

    private void display() {
        XYDataset data = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart("Annotation Test", "X", "Y",
            data, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer
            = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.addAnnotation(new XYShapeAnnotation(initPath(4, 4),
            STROKE, Color.gray, Color.red), Layer.FOREGROUND);
        renderer.addAnnotation(new XYShapeAnnotation(initPath(8, 8),
            STROKE, Color.gray, Color.blue), Layer.FOREGROUND);
        renderer.addAnnotation(new XYShapeAnnotation(initPath(12, 12),
            STROKE, Color.gray, Color.green), Layer.FOREGROUND);
        ChartFrame frame = new ChartFrame("Annotation Test", chart);
        frame.pack();
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private GeneralPath initPath(int x, int y) {
        GeneralPath path = new GeneralPath();
        path.moveTo(x, y);
        path.lineTo(x - W, y - H);
        path.lineTo(x + W, y - H);
        path.lineTo(x - W, y + H);
        path.lineTo(x + W, y + H);
        path.lineTo(x, y);
        return path;
    }

    private static XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        XYSeries series = new XYSeries("Test");
        for (int i = 0; i < N; i++) {
            series.add(i, i);
        }
        result.addSeries(series);
        return result;
    }
}