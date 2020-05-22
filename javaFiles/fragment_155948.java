import java.awt.Dimension;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.PolynomialFunction2D;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class FunctionOfYOverScatter
{
    public static void main(String[] args)
    {
        new FunctionOfYOverScatter();
    }

    public FunctionOfYOverScatter()
    {
        XYPlot plot = new XYPlot();

        XYDataset scatterPlotDataset = getScatterPlotDataset();
        plot.setDataset(0, scatterPlotDataset);
        plot.setRenderer(0, new XYLineAndShapeRenderer(false, true));
        plot.setDomainAxis(0, new NumberAxis("Scatterplot domain"));
        plot.setRangeAxis(0, new NumberAxis("Scatterplot range"));
        plot.mapDatasetToDomainAxis(0, 0);
        plot.mapDatasetToRangeAxis(0, 0);

        double minY = -2.0;
        double maxY = 2.0;
        XYDataset functionDataset = 
            getFunctionDataset(0.8, 0.5, 1.2, minY, maxY);
        plot.setDataset(1, functionDataset);
        plot.setRenderer(1, new XYLineAndShapeRenderer(true, false));

        JFreeChart chart = new JFreeChart("Function of Y over scatter plot",
            JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        ApplicationFrame frame = new ApplicationFrame("Example");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private XYDataset getFunctionDataset(
        double a0, double a1, double a2,
        double minY, double maxY)
    {
        double[] a = { a0, a1, a2 };
        Function2D p = new PolynomialFunction2D(a);
        XYSeries series = sampleFunctionOverY(p, minY, maxY, 100, "Function");
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public static XYSeries sampleFunctionOverY(Function2D f, double start,
        double end, int samples, Comparable<?> seriesKey)
    {
        XYSeries series = new XYSeries(seriesKey, false);
        double step = (end - start) / (samples - 1);
        for (int i = 0; i < samples; i++)
        {
            double y = start + step * i;
            series.add(f.getValue(y), y);
        }
        return series;
    }


    private XYDataset getScatterPlotDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("Scatterplot");
        data.add(3.0, 2.0);
        data.add(1.7, 1.0);
        data.add(2.0, -1.0);
        data.add(1.0, 1.8);
        dataset.addSeries(data);
        return dataset;
    }


}