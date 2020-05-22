import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;

public class CarMeter extends ApplicationFrame {

    private DefaultValueDataset dataset;
    private int value = 50000;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarMeter();
            }
        });
    }

    public CarMeter(String s) {
        super(s);
        JPanel panel = createPanel();
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        Timer t = new Timer(250, new ActionListener() {
            Random r = new Random();

            @Override
            public void actionPerformed(ActionEvent e) {
                value -= (int) (Math.abs(100 * r.nextGaussian()));
                update(value);
            }
        });
        t.start();
    }

    public CarMeter() {
        this("Test");
    }

    private JFreeChart createChart(ValueDataset valuedataset) {
        MeterPlot meterplot = new MeterPlot(valuedataset);
        meterplot.setRange(new Range(0.0D, 100000D));
        meterplot.addInterval(new MeterInterval("Battery LOW", new Range(0.0D, 10000D),
            Color.red, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));
        meterplot.addInterval(new MeterInterval("Moderate", new Range(10000D, 90000D),
            Color.yellow, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
        meterplot.addInterval(new MeterInterval("Battery FULL", new Range(90000D, 100000D),
            Color.green, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));

        meterplot.setNeedlePaint(Color.darkGray);
        meterplot.setDialBackgroundPaint(Color.white);
        meterplot.setDialOutlinePaint(Color.black);
        meterplot.setDialShape(DialShape.CHORD);
        meterplot.setMeterAngle(180);
        meterplot.setTickLabelsVisible(true);
        meterplot.setTickLabelFont(new Font("Arial", 1, 14));
        meterplot.setTickLabelPaint(Color.black);
        meterplot.setTickSize(5D);
        meterplot.setTickPaint(Color.gray);
        meterplot.setValuePaint(Color.black);
        meterplot.setValueFont(new Font("Arial", 1, 14));
        JFreeChart jfreechart = new JFreeChart("Battery Level",
            JFreeChart.DEFAULT_TITLE_FONT, meterplot, true);
        return jfreechart;
    }

    private JPanel createPanel() {
        dataset = new DefaultValueDataset(value);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartpanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        return chartpanel;
    }

    public void update(int data) {
        dataset.setValue(data);

    }
}