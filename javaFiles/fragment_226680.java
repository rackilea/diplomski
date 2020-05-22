import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see http://stackoverflow.com/a/37020264/230513
 */
public class Test {

    private final XYSeries signal = new XYSeries("signal");
    private final XYSeriesCollection dataset = new XYSeriesCollection(signal);

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Signal chart", "Time(T)", "Voltage(V)", dataset);
        f.add(new ChartPanel(chart));
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JButton(new AbstractAction("Load signal") {
            @Override
            public void actionPerformed(ActionEvent e) {
                signal.clear();
                List<Double> list = ReadFile.readFile();
                int i = 0;
                for (Double d : list) {
                    signal.add(i++, d);
                }
            }
        }));
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class ReadFile {

        private static final Random R = new Random();

        public static List<Double> readFile() {
            List<Double> list = Stream.iterate(4.0, x -> x - (R.nextDouble() / 42))
                .limit(42).collect(Collectors.toList());
            return list;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}