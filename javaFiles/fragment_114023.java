import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @see https://stackoverflow.com/a/21267585/230513
 */
public class Test {

    private static final String ROW_KEY = "Values";
    private static final Random r = new Random();

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final DefaultCategoryDataset model = new DefaultCategoryDataset();
        model.setValue(1, ROW_KEY, "1");
        model.setValue(2, ROW_KEY, "2");
        model.setValue(3, ROW_KEY, "3");
        JFreeChart chart = ChartFactory.createBarChart("Proxi", "Sensors",
            "Value", model, PlotOrientation.VERTICAL, false, true, false);
        ChartPanel barPanel = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        f.add(barPanel);
        f.add(new JButton(new AbstractAction("Update") {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.setValue(r.nextDouble() * 3, ROW_KEY, "2");
            }
        }), BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().display();
            }
        });
    }
}