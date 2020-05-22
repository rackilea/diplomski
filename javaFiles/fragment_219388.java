@Override
public void start(Stage stage) throws Exception{

    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, 600, 575);


    stage.setScene(scene);
    stage.setTitle("Test");
    stage.setResizable(false);
    stage.show();

    System.out.println(scene.lookup("#vBox"));
}