public static void showBookView(Trip rowData) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("BookView.fxml"));
    loader.setControllerFactory(type -> {
        if (type == BookViewController.class) {
            return new BookViewController(rowData);
        }
        // default behavior: need this in case there are <fx:include> in the FXML
        try {
            return type.getConstructor().newInstance();
        } catch (Exception exc) {
            // fatal...
            throw new RuntimeException(exc);
        }
    });
    BorderPane bookTrip = loader.load();

    Stage bookStage = new Stage();                
    bookStage.setTitle("BookingApp");
    bookStage.initModality(Modality.WINDOW_MODAL);
    bookStage.initOwner(primaryStage);
    Scene scene = new Scene(bookTrip);
    bookStage.setScene(scene);
    bookStage.showAndWait();
}