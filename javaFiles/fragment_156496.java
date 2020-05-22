import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;

//* @see https://stackoverflow.com/a/25416067/230513 */
public class Test {

    public static void main(String[] args) {
        JPanel panel = new JPanel(new GridLayout());
        panel.add(createChart("Sales", Chart_Type.DOLLARS, 100000, 115000));
        panel.add(createChart("Quotes", Chart_Type.DOLLARS, 250000, 240000));
        panel.add(createChart("Profits", Chart_Type.PERCENTAGE, 40.00, 38.00));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static ChartPanel createChart(String title, Chart_Type type, double goal, double actual) {
        double maxValue = goal * 2;
        double yellowToGreenNum = goal;
        double redToYellowNum = goal * .75;
        DefaultValueDataset dataset = new DefaultValueDataset(actual);

        JFreeChart jfreechart = createChart(dataset, Math.max(actual, maxValue), redToYellowNum, yellowToGreenNum, title, type);
        ChartPanel chartPanel = new ChartPanel(jfreechart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        chartPanel.setBorder(new LineBorder(Color.red));
        return chartPanel;
    }

    private static JFreeChart createChart(ValueDataset valuedataset, Number maxValue, Number redToYellowNum, Number yellowToGreenNum, String title, Chart_Type type) {
        MeterPlot meterplot = new MeterPlot(valuedataset) {

            @Override
            public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info) {
                double h = area.getHeight() * 6 / 5;
                area.setRect(area.getX(), area.getY(), area.getWidth(), h);
                super.draw(g2, area, anchor, parentState, info);
            }
        };
        meterplot.setRange(new Range(0.0D, maxValue.doubleValue()));
        meterplot.addInterval(new MeterInterval(" Goal Not Met ",
                new Range(0.0D, redToYellowNum.doubleValue()), Color.lightGray, new BasicStroke(2.0F),
                new Color(255, 0, 0, 128)));
        meterplot.addInterval(new MeterInterval(" Goal Almost Met ",
                new Range(redToYellowNum.doubleValue(), yellowToGreenNum.doubleValue()), Color.lightGray, new BasicStroke(2.0F),
                new Color(255, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval(" Goal Met ",
                new Range(yellowToGreenNum.doubleValue(), maxValue.doubleValue()), Color.lightGray, new BasicStroke(2.0F),
                new Color(0, 255, 0, 64)));
        meterplot.setNeedlePaint(Color.darkGray);
        meterplot.setDialBackgroundPaint(Color.white);
        meterplot.setDialOutlinePaint(Color.gray);
        meterplot.setDialShape(DialShape.CHORD);
        meterplot.setMeterAngle(260);
        meterplot.setTickLabelsVisible(false);

        meterplot.setTickSize(maxValue.doubleValue() / 20);
        meterplot.setTickPaint(Color.lightGray);

        meterplot.setValuePaint(Color.black);
        meterplot.setValueFont(new Font("Dialog", Font.BOLD, 0));
        meterplot.setUnits("");
        if (type == Chart_Type.DOLLARS) {
            meterplot.setTickLabelFormat(NumberFormat.getCurrencyInstance());
        } else if (type == Chart_Type.PERCENTAGE) {
            meterplot.setTickLabelFormat(NumberFormat.getPercentInstance());
        }
        meterplot.setDrawBorder(true);
        meterplot.setDialShape(DialShape.CHORD);
        JFreeChart jfreechart = new JFreeChart(title,
                JFreeChart.DEFAULT_TITLE_FONT, meterplot, false);
        return jfreechart;
    }

    enum Chart_Type {

        DOLLARS,
        PERCENTAGE
    }
}