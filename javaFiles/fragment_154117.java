FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("Shapes.fxml"));

    TitledPane TitledP = (TitledPane) loader.load();

    Pane.getChildren().add(TitledP);