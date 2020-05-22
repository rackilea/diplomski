public void update() {
    for (XYChart.Data<String, Number> data : series.getData()) {
        Number oldValue = data.getYValue();
        data.setYValue(oldValue.intValue() + 5);

    }
}