public class SceneController implements Initializable{

    // non-table code omitted...

    @FXML
    private TableView<Song> table;
    @FXML
    private Label label;
    @FXML
    private ProgressBar proBar;
    @FXML
    private TableColumn<Song, String> songCol ;
    @FXML
    private TableColumn<Song, String> artistCol ;
    @FXML
    private TableColumn<Song, String> albumCol;

    ObservableList<Song> songList = FXCollections.observableArrayList();
    List<File> list;
    FileChooser fileChooser = new FileChooser();
    Desktop desktop;
    Song mySong;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        songCol.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        artistCol.setCellValueFactory(cellData -> cellData.getValue().artistProperty());
        albumCol.setCellValueFactory(cellData -> cellData.getValue().albumProperty());

        // ...

    }

    // other non-table code omitted...

}