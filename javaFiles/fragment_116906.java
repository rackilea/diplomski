@Override
public void start(Stage primaryStage) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));

    // initialize namespace
    Map<String, Object> namespace = loader.getNamespace();
    namespace.put("a", 10d);
    namespace.put("b", 20d);

    Scene scene = new Scene(loader.load());

    primaryStage.setScene(scene);
    primaryStage.show();
}