public class Controller {

    @FXML private SplitPane splitpane;
    @FXML private Button buttonA ;
    @FXML private Button buttonB ;

    private int contentIndex ;        


    @FXML
    public void initialize() {
        buttonA.setDisable(true);
        contentIndex = splitPane.getItems().size() ;
        changeContent(new ContentA()); 
    }



    @FXML
    public void onMenuClickA(ActionEvent event) {
        buttonA.setDisable(true);
        buttonB.setDisable(false);
        changeContent(new ContentA());
    }
    @FXML
    public void onMenuClickB(ActionEvent event) {
        buttonA.setDisable(false);
        buttonB.setDisable(true);
        changeContent(new ContentB());
    }




    private void changeContent(Node node) {
        splitpaneItems.set(splitpaneItems.indexOf(content), node);
    }

}