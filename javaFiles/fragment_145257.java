public class NoteKeeperController implements Initializable{
    NoteBook noteBook;
    TreeItem<String> rootItem;

    public BorderPane root;

    @FXML private TreeView<String> noteTree;

    @FXML private ScrollPane sp;
    @FXML private Button newNoteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        rootItem = new TreeItem<String> ("FirstNote");
        rootItem.setExpanded(true);     
        noteTree.setRoot(rootItem);

        noteBook= new NoteBook();

    }

    // ...
}