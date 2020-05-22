public void update(ComputationState finalState) {
    getData().clear();
    XYChart.Series<Number, Number> series = new XYChart.Series<>();

    final int imgWidth = 20 ; 
    final int imgHeight = 20 ; 
    final Image img = new Image(getClass().getResource("pizza.png"), imgWidth, imgHeight, true, true, true);

    for (PizzaDeliverer entry : finalState.getPizzas()) {
        XYChart.Data<Number, Number> dataEntry = new XYChart.Data<>(entry.getCurrentPosition().getX(), entry.getCurrentPosition().getY());
        dataEntry.setNode(new ImageView(img));
        series.getData().add(dataEntry);
    }
    series.setName(null);
    getData().add(series);
}