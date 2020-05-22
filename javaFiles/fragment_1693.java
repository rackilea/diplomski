ObservableList<PieChart.Data> pieChartDataTemp = pieChartData;
int sizeOne = pieChartDataTemp.size();
PieChart.Data tempData = pieChartDataTemp.get(sizeOne - 1);
pieChartDataTemp.add(0,tempData);
if (pieChartDataTemp.size() > sizeOne) {
    pieChartDataTemp.remove(pieChartDataTemp.size() - 1);
}

PieChart chartTemp = new PieChart(pieChartDataTemp);
layout.setCenter(chartTemp);
chartTemp.setStartAngle(90);