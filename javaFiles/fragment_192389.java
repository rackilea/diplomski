import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JLabel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

/**
* An example showing how to convert the mouse location to chart coordinates.
*/
public class MouseListenerDemo4 extends ApplicationFrame  
                                implements ChartMouseListener {

    private JFreeChart chart;

    private ChartPanel chartPanel;
    private JLabel priceLabel;


    public MouseListenerDemo4(String title) {
        super(title);
        priceLabel=new JLabel("");
        priceLabel.setBounds(5000, 5, 50, 20);
        String chartTitle = "Mouse Listener Demo 4";
        String file="D:\\CL.txt";
        OHLCDataset data2 = createPriceDataset(file);
        System.out.println(data2.getItemCount(0));
        HighLowRenderer renderer1 = new HighLowRenderer();
        renderer1.setTickLength(3);
        renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator
                                            (StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT, 
                                                    new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
        renderer1.setSeriesPaint(0, Color.blue);

        DateAxis domainAxis = new DateAxis("Date");
        NumberAxis rangeAxis = new NumberAxis("Price");
        rangeAxis.setNumberFormatOverride(new DecimalFormat("$0.00"));
        rangeAxis.setAutoRange(true);
        rangeAxis.setAutoRangeIncludesZero(false);
        ChartColor chartColor=new ChartColor(0, 0, 0);

        XYPlot plot1 = new XYPlot(data2, domainAxis, rangeAxis, renderer1);
        plot1.getRangeCrosshairPaint();
        plot1.setBackgroundPaint(Color.white);
        plot1.setDomainGridlinePaint(Color.magenta);
        plot1.setRangeGridlinePaint(Color.magenta);
        plot1.setRangePannable(true);

        plot1.setRangeCrosshairVisible(true);
        plot1.setRangeCrosshairValue(4000, true);
        plot1.setRangeCrosshairLockedOnData(true);
        plot1.setRangeCrosshairVisible(true);



        this.chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot1, false);
        chartPanel = new ChartPanel(this.chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        chartPanel.setMouseZoomable(true, false);
        chartPanel.addChartMouseListener(this);
        setContentPane(chartPanel);

        priceLabel.setBackground(Color.cyan);
        chartPanel.add(priceLabel);
        priceLabel.setVisible(true);
        priceLabel.setText("");
    }
    private static OHLCDataset createPriceDataset(String filename) {
        // the following data is taken from http://finance.yahoo.com/
        // for demo purposes...

        OHLCSeries s1 = new OHLCSeries(filename);

        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String inputLine;
            in.readLine();
            while ((inputLine = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inputLine, ",");
                Date date = df.parse(st.nextToken());
                double open = Double.parseDouble(st.nextToken());
                double high = Double.parseDouble(st.nextToken());
                double low = Double.parseDouble(st.nextToken());
                double close = Double.parseDouble(st.nextToken());
                double volume = Double.parseDouble(st.nextToken());

                s1.add(new Day(date), open, high, low, close);
                //t1.add(new Day(date), close);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OHLCSeriesCollection dataset = new OHLCSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
    }


    /**
     * Creates a sample dataset.
     *
     * @return The dataset.
     */


    /**
     * Receives chart mouse click events.
     *
     * @param event  the event.
     */
    public void chartMouseClicked(ChartMouseEvent event) {
        int mouseX = event.getTrigger().getX();
        int mouseY = event.getTrigger().getY();
        System.out.println("x = " + mouseX + ", y = " + mouseY);        
        Point2D p = chartPanel.translateScreenToJava2D(
                new Point(mouseX, mouseY));
        XYPlot plot = (XYPlot) chart.getPlot();
        Rectangle2D plotArea = this.chartPanel.getChartRenderingInfo().getPlotInfo().getDataArea();
        ValueAxis domainAxis = plot.getDomainAxis();
        RectangleEdge domainAxisEdge = plot.getDomainAxisEdge();
        ValueAxis rangeAxis = plot.getRangeAxis();
        RectangleEdge rangeAxisEdge = plot.getRangeAxisEdge();
        double chartX = domainAxis.java2DToValue(p.getX(), plotArea, 
                domainAxisEdge);
        double chartY = rangeAxis.java2DToValue(p.getY(), plotArea, 
                rangeAxisEdge);
        this.chartPanel.setHorizontalAxisTrace(true);
        this.chartPanel.setVerticalAxisTrace(true);
        System.out.println("Chart: x = " + chartX + ", y = " + (int)chartY);
        priceLabel.setText(""+(int)chartY);
    }

    /**
     * Receives chart mouse moved events.
     *
     * @param event  the event.
     */
    public void chartMouseMoved(ChartMouseEvent event) {
        // ignore
    }

/**
 * Starting point for the demonstration application.
 *
 * @param args  ignored.
 */
public static void main(String[] args) {
    MouseListenerDemo4 demo = new MouseListenerDemo4(
        "Mouse Listener Demo 4");
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
}