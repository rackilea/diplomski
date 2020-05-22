public class Controller {

    @FXML
    private TableView<Hiscore> table ;
    @FXML
    private TableColumn<Hiscore, String> iconCol ;
    @FXML
    private TableColumn<Hiscore, Number> rankCol ;
    @FXML
    private TableColumn<Hiscore, Number> levelCol ;
    @FXML
    private TableColumn<Hiscore, Number> experienceCol ;

    public void initialize() {
        iconCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIcon()));
        rankCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getRank()));
        // etc etc
    }
}