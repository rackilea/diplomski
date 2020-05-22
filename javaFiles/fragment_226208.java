import javax.swing.JFrame;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class Strofoida extends JFrame {


public Strofoida() {
    super();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    XYSeries series = createSeries();
    XYDataset xyDataset = new XYSeriesCollection(series);
    JFreeChart localJFreeChart = ChartFactory.createXYLineChart("", "X", "Y", xyDataset, PlotOrientation.VERTICAL,
            true, true, false);
    XYPlot localXYPlot = (XYPlot) localJFreeChart.getPlot();
    localXYPlot.setDomainZeroBaselineVisible(true);
    localXYPlot.setRangeZeroBaselineVisible(true);
    ChartPanel chartPanel = new ChartPanel(localJFreeChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    setContentPane(chartPanel);
}

private XYSeries createSeries() {
    XYSeries ser = new XYSeries(new XYDataItem(0, 0), false);
    int a = 1;
    for (double f = -0.9; f <= 0.9; f += 0.01) {
        double u = Math.tan(f);
        ser.add(a * (u * u - 1) / (u * u + 1), a * u * (u * u - 1) / (u * u + 1));
    }
    return ser;
}

static class Main {
    public static void main(String[] args) {
        Strofoida strofoida = new Strofoida();
        strofoida.pack();
        strofoida.setVisible(true);
    }
}


}