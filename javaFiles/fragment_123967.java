public JFreeChart createChart()
{
  chart = ...
  PiePlot plot = (PiePlot)chart.getPlot();
  plot.setLabelGenerator(new CustomLabelGenerator());

  return chart;
}

public class CustomLabelGenerator implements PieSectionLabelGenerator {
  public String generateSectionLabel(PieDataset dataset, Comparable key)
  {
    return "my Label for " + dataset.getValue(key);
  }
  public String generateSectionLabel(PieDataset dataset, Comparable key)
  {
    return null;
  }
}