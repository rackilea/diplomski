public static void main(String[] args) {
    Application.launch(Test.class, args);
}

private static Stage stage1;
private static Stage stage2;    
private static MyExampleController controller;

@Override
public void start(Stage primaryStage) throws Exception {
    stage1 = primaryStage;        
    FXMLLoader loader1 = new FXMLLoader(Test.class.getResource("/test/MyExample.fxml"));
    AnchorPane pane1 = (AnchorPane)loader1.load();
    controller = loader1.getController();
    Scene scene1 = new Scene(pane1);
    stage1.setScene(scene1);

    stage2 = new Stage();
    FXMLLoader loader2 = new FXMLLoader(Test.class.getResource("/test/MyEx2.fxml"));
    AnchorPane pane2 = (AnchorPane)loader2.load();
    Scene scene2 = new Scene(pane2);
    stage2.setScene(scene2);

    stage1.show();
}

public static Stage getStage2(){
    return stage2;
}

public static MyExampleController getController(){
    return controller;
}