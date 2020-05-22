import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartx extends ApplicationFrame {

    public BarChartx(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "year", "value", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot p = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) p.getRenderer();
        renderer.setSeriesPaint(0, new Color(255, 0, 102));
        renderer.setSeriesPaint(1, new Color(0, 153, 255));
        renderer.setItemMargin(0.03);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        final String apple = "apple";
        final String mango = "mango";

        final String y2000 = "2000";
        final String y2001 = "2001";
        final String y2002 = "2002";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(700, apple, y2000);
        dataset.addValue(550, mango, y2000);

        dataset.addValue(700, apple, y2001);
        dataset.addValue(550, mango, y2001);

        dataset.addValue(720, apple, y2002);
        dataset.addValue(570, mango, y2002);

        return dataset;
    }

    public static void main(String[] args) {
        BarChartx chart = new BarChartx("example", "Bar Chart Demo 1");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}