/** @see https://stackoverflow.com/questions/9338466 */
public class InternalFreeChart {

    private static final Random rnd = new Random();

    public InternalFreeChart() {
        JFrame frame = new JFrame();
        JDesktopPane desktop = new JDesktopPane();
        frame.add(desktop);
        for (int i = 1; i < 9; i++) {
            desktop.add(createInternalFrame(i));
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JInternalFrame createInternalFrame(int n) {
        JInternalFrame jif = new JInternalFrame(
            "Frame" + n, true, true, true, true);
        jif.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Test", "Time", "Value", createDataset(), true, true, false);
        JPanel chartPanel = new ChartPanel(chart);
        jif.add(chartPanel);
        jif.pack();
        jif.setBounds(n * 25, n * 20, 400, 300);
        jif.setVisible(true);
        return jif;
    }

    private static XYDataset createDataset() {
        TimeSeries series1 = new TimeSeries("Series 1");
        TimeSeries series2 = new TimeSeries("Series 2");
        SerialDate sd = SerialDate.createInstance(new Date());
        for (int i = 1; i < 16; i++) {
            Day d = new Day(SerialDate.addDays(i, sd));
            series1.add(d, 100 + rnd.nextGaussian() / 2);
            series2.add(d, 101 + rnd.nextGaussian() / 2);
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                InternalFreeChart ifc = new InternalFreeChart();
            }
        });
    }
}