FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("windows/configureTemplates.fxml"));

AnchorPane root = null;

try {
    root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.showAndWait();
    ControllerA controllerA = loader.getController();
    System.out.println(controllerA.getWords().size());
} catch (IOException e) {
    e.printStackTrace();
}