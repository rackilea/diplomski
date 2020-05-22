FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/file.fxml"));
Parent root = loader.load();
Controller controller = loader.getController();
Scene scene = new Scene(root);
Stage stage = new Stage();
stage.setScene(scene);
stage.setOnHidden(e -> {
    controller.shutdown();
    Platform.exit();
});
stage.show();