public class Controller {

    @FXML private SplitPane splitpane;

    private ContentA contentA ;
    private ContentB contentB ; 

    private int contentIndex ;        

    @FXML
    public void initialize() {
        contentA = new ContentA();
        contentB = new ContentB();
        contentIndex = splitPane.getItems().size() ;
        splitPane.getItems().set(contentIndex, contentA);
    }



    @FXML
    public void onMenuClickA(ActionEvent event) {
        changeContent(contentA);
    }
    @FXML
    public void onMenuClickB(ActionEvent event) {
        changeContent(contentB);
    }

    private void changeContent(Node node) {
        splitpaneItems.set(contentIndex, node);
    }

}