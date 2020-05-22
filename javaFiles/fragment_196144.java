private void chartRefresh() {

    series.getData().clear();
    if (level < datas.length) {

        for (int i = 0; i < datas[level].length; i++) {
            Data<Number, Number> data = new Data<Number, Number>(i, datas[level][i]);
            data.setNode(new Circle(3, Color.RED));
            series.getData().add(data);
        }
    }
    level++;

    chart.getData().clear();
    chart.getData().add(series);
    series.getNode().setStyle("-fx-stroke:blue;-fx-stroke-width:1");

    // reDrawShapes(series);
}