import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

/**
 * @see http://en.wikipedia.org/wiki/Polar_coordinate_system
 * @see https://stackoverflow.com/questions/3458824
 */
public class ArchimedesSpiral extends JFrame {

    private static final String title = "Archimedes' Spiral";

    public ArchimedesSpiral(String title) {
        super(title);
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setMouseZoomable(false);
        this.add(panel);
    }

    private static XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        XYSeries series = new XYSeries(title);
        for (int t = 0; t <= 3 * 360; t++) {
            series.add(90 - t, t);
        }
        result.addSeries(series);
        return result;
    }

    private static JFreeChart createChart(XYDataset dataset) {
        ValueAxis radiusAxis = new NumberAxis();
        radiusAxis.setTickLabelsVisible(false);
        PolarItemRenderer renderer = new DefaultPolarItemRenderer();
        PolarPlot plot = new PolarPlot(dataset, radiusAxis, renderer) {

            @Override
            protected List refreshAngleTicks() {
                List<NumberTick> ticks = new ArrayList<NumberTick>();
                int delta = (int) this.getAngleTickUnit().getSize();
                for (int t = 0; t < 360; t += delta) {
                    int tp = (360 + 90 - t) % 360;
                    NumberTick tick = new NumberTick(
                        Double.valueOf(t), String.valueOf(tp),
                        TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
                    ticks.add(tick);
                }
                return ticks;
            }
        };
        plot.setBackgroundPaint(new Color(0x00f0f0f0));
        plot.setRadiusGridlinePaint(Color.gray);
        plot.addCornerTextItem("r(θ) = θ; 0 < θ < 6π");
        JFreeChart chart = new JFreeChart(
            title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public static void main(String[] args) {
        ArchimedesSpiral demo = new ArchimedesSpiral(title);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    }
}