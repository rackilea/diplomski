public class AddImage extends TableCell<YourEntity, Boolean> {

final StackPane paddedButton = new StackPane();
final HBox hbox = new HBox();
final VBox vbox = new VBox();
Stage primaryStage = new Stage();
Scene scene = new Scene(new Group());


Image img = new Image("../your image path or url ");

public AddImage(final Stage stage, final TableView table) {

  paddedButton.setPadding(new Insets(3));

  vbox.getChildren().add(img);


  hbox.getChildren().add(vbox);

  hbox.setPadding(new Insets(30, 5, 5, 5));

  paddedButton.getChildren().add(hbox);
  //primaryStage.setScene(scene);
  //primaryStage.show();



}
@Override protected void updateItem(Boolean item, boolean empty) {
    super.updateItem(item, empty);
    if (empty) {
setGraphic(null);
 }
else{
      setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
      setGraphic(paddedButton);
    }
  }
}