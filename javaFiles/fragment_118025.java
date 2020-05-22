public class ListViewSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List View Sample");        

        ListView<String> list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList ( "Single", "Double", "Suite", "Family App");
        list.setItems(items);    

        // filter right mouse button
        list.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> 
        {
            if( e.isSecondaryButtonDown()) {
                e.consume();
            }

        });

        list.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);

        // verify selection via logging
        list.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> System.out.println( "Item selected: " + observable + ", " + oldValue + ", " + newValue)
                );

        StackPane root = new StackPane();
        root.getChildren().add(list);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}