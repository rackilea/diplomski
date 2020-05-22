public class JavaFXApplication4 extends Application {

@Override
public void start(Stage stage) {
   Button jb = new Button("Click");
   jb.setOnMouseClicked(new EventHandler() {
        @Override
           public void handle(Event event) {
               makeAnotherStage(stage);
           }
       });

       GridPane gp = new GridPane();
       gp.getChildren().add(jb);
       Scene s = new Scene(gp);

       stage.setScene(s);
       stage.show();

    }

    private void makeAnotherStage(Stage st){
        Stage s = new Stage();

        GridPane gp = new GridPane();
        Label l = new Label("Second Stage");
        gp.getChildren().add(l);
        Scene sc = new Scene(gp);

        s.initOwner(st);                        <------- initOwner
        s.initModality(Modality.WINDOW_MODAL);  <------- Modality property

        s.setScene(sc);
        s.requestFocus();
        s.show();
    }
}