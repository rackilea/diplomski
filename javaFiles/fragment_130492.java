@Override
public void start(Stage stage) {
    Pane p = new Pane();
    p.setStyle("-fx-background-color: red");
    stage.setTitle("I AM THE PARENT");
    Scene scene = new Scene(p);
    stage.setWidth(600);
    stage.setHeight(600);
    stage.setScene(scene);
    stage.show();
    Stage s = new Stage(StageStyle.DECORATED);
    s.initModality(Modality.APPLICATION_MODAL);
    p = new Pane();
    p.setStyle("-fx-background-color: yellow");
    s.setScene(new Scene(p,150,150));
    //s.initOwner(stage); //with this commented it wont work
    s.show();
}