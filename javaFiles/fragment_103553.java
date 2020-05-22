import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import au.com.bytecode.opencsv.CSVReader;

public class Test extends ApplicationFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    XYSeriesCollection dataset;
    JFreeChart chart;
    final ChartPanel chartPanel;
    final int chartWidth = 560;
    final int chartHeight = 367;
    CSVReader reader;
    String[] readNextLine;
    XYSeries series;

    public Test(String applicationTitle) throws IOException {
        super(applicationTitle);
        dataset = createDataset();
        chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(chartHeight,
                chartWidth));
        this.add(chartPanel);
    }

    public XYSeriesCollection createDataset() throws NumberFormatException,
            IOException {
        dataset = new XYSeriesCollection();
        try {
            reader = new CSVReader(new FileReader("res\\data.csv"),'\t');
            // Read the header and chuck it away
            readNextLine = reader.readNext();

            // Set up series
            final XYSeries seriesX = new XYSeries("X");
            final XYSeries seriesY = new XYSeries("Y");
            final XYSeries seriesZ = new XYSeries("Z");

            while ((readNextLine = reader.readNext()) != null) {
                // add values to dataset
                double Time = Double.valueOf(readNextLine[0]);
                double X = Double.valueOf(readNextLine[1]);
                double Y = Double.valueOf(readNextLine[2]);
                double Z = Double.valueOf(readNextLine[3]);
                seriesX.add(Time, X);
                seriesY.add(Time, Y);
                seriesZ.add(Time, Z);
            }

            System.out.println(seriesX.getMaxX() + "; " + seriesX.getMaxY());

            dataset.addSeries(seriesX);
            dataset.addSeries(seriesY);
            dataset.addSeries(seriesZ);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return dataset;
    }

    public JFreeChart createChart(XYDataset dataset)
            throws NumberFormatException, IOException {
        chart = ChartFactory.createXYLineChart("Acceleration vs Time", // chart
                                                                        // title
                "Time", // domain axis label
                "Acceleration", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // the plot orientation
                true, // legend
                true, // tooltips
                false); // urls

        return chart;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("In here, to create a Test");
        final Test demo = new Test("Test XY Line chart");
        System.out.println("Created, pakcking");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}