public void handle(ActionEvent event) {
    listLayout.getChildren().removeIf(CarLabel.class::isInstance);
    Collections.sort(listOfCars, ListYears.yearCom);
    for(Object o : listOfCars) {
        result = new CarLabel(o.toString());
        result.setTranslateX(20);
        result.setTranslateY(-40);
        listLayout.getChildren().add(result);
    }
}