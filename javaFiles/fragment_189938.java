public static Scene secondScene(final Stage primaryStage){
     BorderPane pane = new BorderPane();
     Label l = new Label("Second Scene");
     pane.setCenter(l);

      //let's say I have a button that changes back to original stage
     Button b = new Button("Main stage");  
     b.setOnAction(new EventHandler<ActionEvent>(){
     public void handle(ActionEvent t){
           // create your own Scene and then set it to primaryStage
          primaryStage.setScene(new Scene ... );
     }
     });

     return new Scene(pane, 300, 300);
}