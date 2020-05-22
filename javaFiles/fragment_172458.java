@Override
public Component getListCellRendererComponent(
    JList modelList, XYSeriesCollection series,
        int index, boolean isSelected, boolean hasFocus) {
    XYPlot plot = chart.getXYPlot();
    plot.setDataset(series);
    return chartPanel;
}