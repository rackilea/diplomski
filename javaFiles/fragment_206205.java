import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartSingleton {
  private static ChartSingleton instance = null;
  private static ChartPanel chartPanel = null;

  private ChartSingleton() {
    chartPanel = new ChartPanel(generatePieChart());
  }

  public static ChartSingleton getInstance() {
    if (instance == null) {
      instance = new ChartSingleton();
    }
    return instance;
  }

  private JFreeChart generatePieChart() {
    DefaultPieDataset dataSet = new DefaultPieDataset();
    dataSet.setValue("China",        1344.0);
    dataSet.setValue("India",        1241.0);
    dataSet.setValue("United States", 310.5);

    return ChartFactory.createPieChart(
            "Population 2011", dataSet, true, true, false
    );
  }

  public ChartPanel getChartPanel() {
    return chartPanel;
  }
}