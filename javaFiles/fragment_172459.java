import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/q/46527131/230513
 * @see https://stackoverflow.com/a/40445144/230513
 */
public class ModelListTest {

    public static void main(final String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Test");
                f.add(new JScrollPane(new ModelList()));
                f.pack();
                f.setSize(640, 480);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    private static class ModelList extends JList<XYSeriesCollection> {

        private static final Random random = new Random();
        private static final int charts = 50;
        private static final int samples = 200;
        private static final int W = 300;
        private static final int H = W;

        ModelList() {
            DefaultListModel<XYSeriesCollection> listModel = new DefaultListModel<>();
            for (int i = 0; i < charts; i++) {
                listModel.addElement(createRandomSeries());
            }
            this.setModel(listModel);
            this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            this.setCellRenderer(new ModelListRenderer());
            this.setVisibleRowCount(0);
            this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            this.setSelectionForeground(Color.RED);
        }

        private static XYSeriesCollection createRandomSeries() {
            final XYSeries series = new XYSeries("Data");
            for (int i = 0; i < random.nextInt(samples) + samples; i++) {
                series.add(i, random.nextGaussian());
            }
            XYSeriesCollection dataset = new XYSeriesCollection(series);
            return dataset;
        }

        private static class ModelListRenderer implements ListCellRenderer<XYSeriesCollection> {

            private JFreeChart chart;
            private ChartPanel chartPanel;

            public ModelListRenderer() {
                chart = ChartFactory.createXYLineChart("Random", "counts", "samples", null);
                chartPanel = new ChartPanel(chart, true, true, true, false, true) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(W, H);
                    }
                };
            }

            @Override
            public Component getListCellRendererComponent(
                JList modelList, XYSeriesCollection series, int index, boolean isSelected, boolean hasFocus) {
                XYPlot plot = chart.getXYPlot();
                plot.setDataset(series);
                return chartPanel;
            }
        }
    }
}