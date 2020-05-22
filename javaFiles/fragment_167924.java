if (m_chartType == PieChart) {
  double sum = 0;
  for (int k = 0; k < dataLength; k++) {
    yData[k] = Math.max(yData[k], 0);
    sum += yData[k];
  }
  pieData = new double[dataLength];
  for (int k = 0; k < dataLength; k++)
    pieData[k] = yData[k] * 360.0 / sum;
  chartPanel = new ChartPanel();
  add(chartPanel, BorderLayout.CENTER);
}