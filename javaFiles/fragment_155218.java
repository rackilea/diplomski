import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Skyplot {

    private double[] position = null;
    private JFrame plotFrame = null;

    public static void main(String[] args) {
        Skyplot sp = new Skyplot();
        sp.display();
    }

    public Skyplot() {
    }

    public void display() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                plot();
            }
        });
    }

    private void plot() {
        // create and set up the window
        plotFrame = new JFrame("Visualizer");
        plotFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Display the window.
        plotFrame.pack();
        plotFrame.setSize(800, 600);
        plotFrame.setLocationRelativeTo(null);
        plotFrame.setVisible(true);

        // set up the content pane
        Container C = plotFrame.getContentPane();

        Plotter pl = new Plotter();
        pl.setBorder(BorderFactory.createRaisedBevelBorder());
        pl.setBackground(Color.WHITE);

        C.setLayout(new GridLayout(1, 1));
        C.add(pl);
    }

    private class Plotter extends JPanel {

        private static final long serialVersionUID = 1L;

        public Plotter() {
            XYDataset dataset = getXYDataset();

            final ChartPanel chartPanel = createChartPanel(dataset);
            this.add(chartPanel, BorderLayout.CENTER);
        }

        private ChartPanel createChartPanel(XYDataset dataset) {
            // Create chart
            JFreeChart chart = ChartFactory.createPolarChart("Skyplot", dataset, true, true, false);
            LegendTitle title = chart.getLegend();
            title.setItemFont(new Font(Font.SERIF, Font.BOLD, 24));

            PolarPlot polPlot = (PolarPlot) chart.getPlot();
            polPlot.setRadiusMinorGridlinesVisible(false);
            polPlot.setBackgroundPaint(Color.WHITE);
            polPlot.setRadiusGridlinePaint(Color.DARK_GRAY);
            polPlot.setAngleGridlinePaint(Color.BLACK);

            DefaultPolarItemRenderer renderer = (DefaultPolarItemRenderer) polPlot.getRenderer();
            renderer.setBaseLegendShape(new Rectangle(15, 15));
            renderer.setShapesVisible(true);

            NumberAxis rangeAxis = (NumberAxis) polPlot.getAxis();
            rangeAxis.setTickUnit(new NumberTickUnit(10.0));
            rangeAxis.setMinorTickMarksVisible(false);
            rangeAxis.setRange(0.0, 90.0);
            rangeAxis.setInverted(true);

            return new ChartPanel(chart) {
                @Override
                public Dimension getPreferredSize() {
                    double H = plotFrame.getHeight() * 0.9;
                    double W = plotFrame.getWidth() * 0.9;
                    return new Dimension((int) W, (int) H);
                }
            };
        }

        private XYDataset getXYDataset() {
            XYSeriesCollection dataset = new XYSeriesCollection();

            XYSeries g01 = new XYSeries("G01");
            g01.add(35, 45);
            dataset.addSeries(g01);

            XYSeries g02 = new XYSeries("G02");
            g02.add(105, 73);
            dataset.addSeries(g02);

            XYSeries g03 = new XYSeries("G03");
            g03.add(264, 15);
            dataset.addSeries(g03);

            return dataset;
        }
    }
}