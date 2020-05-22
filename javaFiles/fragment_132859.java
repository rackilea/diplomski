public class AnotherWindow extends Application {    
    @Override
    public void start(Stage primaryStage) {
    final Button b = new Button("Back");
    b.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent t) {               
           ((Button)t.getTarget()).getScene().getWindow().hide();              
        }
    });
    ((Group) scene.getRoot()).getChildren().add(b);
    primaryStage.setScene(scene);        
    primaryStage.show();
    }}