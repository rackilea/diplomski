public class Controller {
    @FXML private VBox topLevelContainer; // root fxml element

    @FXML
    void initialize(){

        GridPane gridPane = new GridPane();
        ScrollPane sp = new ScrollPane(gridPane);
        topLevelContainer.getChildren().add(sp);

        // add a 100 buttons to 0th column
        for (int i = 0; i < 100; i++) {
            gridPane.add(new Button("button"),0,i);
        }


    }

}