import java.util.Calendar;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;

public class sample1 {
    private static final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();
    private static final DataFeedingThread dataFeedingThread = new DataFeedingThread();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAll();
            }
        });
    }

    public static void createAll() {
        // window
        JFrame wnd = new JFrame();
        wnd.setVisible(true);
        wnd.setSize(800, 500);
        wnd.setLocationRelativeTo(null);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // chart series
        seriesCollection.addSeries(new OHLCSeries("Test"));

        // chart
        final JFreeChart chart = ChartFactory.createCandlestickChart(null, "Time", "Price", seriesCollection, false);
        chart.getXYPlot().setOrientation(PlotOrientation.VERTICAL);

        // chart panel
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMaximumDrawHeight(2000);
        chartPanel.setMaximumDrawWidth(3000);
        wnd.add(chartPanel);

        // chart data feeding thread
        dataFeedingThread.start();      
    }


    public static void setOHLCSeries(OHLCSeries series) {
        seriesCollection.removeAllSeries();
        seriesCollection.addSeries(series);
    }

    private static class DataFeedingThread implements Runnable {
        private Thread t;

        @Override
        public void run() {

            // run recursively
            while (true) {

                // feed the chart with random data
                SampleDataFeed();

                // what 1 second before next run
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // feed the chart with random data
        private void SampleDataFeed() {
            OHLCSeries series = new OHLCSeries("test");
            for (int i = 0; i < 100; i++) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, i);
                FixedMillisecond fm = new FixedMillisecond(cal.getTime());
                series.add(fm, randInt(95, 105), randInt(105, 110), randInt(90, 95), randInt(95, 105));
            }
            setOHLCSeries(series);
        }

        // return random integer
        private int randInt(int min, int max) {
            Random rand = new Random();
            int randomNum = rand.nextInt((max - min) + 1) + min;
            return randomNum;
        }

        public void start() {
            if (t == null) {
                t = new Thread(this);
                t.start();
            }
        }
    }

}