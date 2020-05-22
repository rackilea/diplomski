import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/** @see http://stackoverflow.com/a/36889641/230513 */
public class PieLineTest {

    private final DefaultCategoryDataset lineData = new DefaultCategoryDataset();

    public void display() {
        final DefaultPieDataset pieData = new DefaultPieDataset();
        pieData.setValue("One", 42);
        pieData.setValue("Two", 84);
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Title", pieData, true, true, false);
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Title", "Domain", "Range", lineData);

        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(0, 1));
        ChartPanel piePanel = new ChartPanel(pieChart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        piePanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent cme) {
                PieSectionEntity e = (PieSectionEntity) cme.getEntity();
                DefaultPieDataset d = (DefaultPieDataset) e.getDataset();
                Comparable sectionKey = e.getSectionKey();
                lineData.clear();
                lineData.addValue(1, e.toString(), "Begin");
                lineData.addValue(d.getValue(sectionKey), e.toString(), "End");
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent event) {
            }
        });
        f.add(piePanel);
        f.add(new ChartPanel(lineChart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PieLineTest().display();
            }
        });
    }

}