@Override
public void start(Stage primaryStage){
BorderPane mainPane = new BorderPane();
Button b = new Button("Register");
mainPane.setCenter(b);

b.setOnAction(new EventHandler<ActionEvent>(){
     public void handle(ActionEvent t){
          primaryStage.setScene(secondScene(primaryStage));
     }
});

  primaryStage.setScene(new Scene(mainPane, 300,300));
  primaryStage.show();
}