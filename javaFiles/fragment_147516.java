public class MainController extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override public void start(Stage primaryStage) throws Exception {


    SpreadsheetView spreadsheetView = new SpreadsheetView();
    //off the standard ContextMenu
    spreadsheetView.setContextMenu(null);
    //set own handler for right click with Dialog
    spreadsheetView.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
      @Override public void handle(ContextMenuEvent event) {
        CellView cellView = (CellView) event.getTarget();
        TextInputDialog dialog = new TextInputDialog(cellView.getText());
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
          System.out.println(cellView.getText());
        }
      }
    });

    HBox hBox = new HBox();
    hBox.getChildren().add(spreadsheetView);
    Scene scene = new Scene(hBox);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}