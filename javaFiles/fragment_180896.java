@Override
public void start(Stage primaryStage) {
    Button btn=new Button("Call function");
    btn.setOnAction(e->{
         engine.executeScript("testCheckMate();");
    });
    Scene scene = new Scene(new VBox(webView,btn), 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}