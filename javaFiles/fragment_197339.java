for (XYChart.Series<Number, Number> series : chart.getData()) {
    List<XYChart.Data<Number, Number>> data = series.getData();
    ObservableList<XYChart.Data<Number, Number>> newData =
            FXCollections.<XYChart.Data<Number, Number>>observableArrayList();
    for (XYChart.Data<Number, Number> item : data) {
        newData.add(new XYChart.Data<Number, Number>(
                item.getXValue(),
                item.getYValue().floatValue() * 1.1));
    }
    series.getData().clear();
    series.setData(newData);
}