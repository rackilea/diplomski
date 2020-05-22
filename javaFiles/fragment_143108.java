public class MainWindowController implements Initializable {
    @FXML
    public TableColumn levelOfGrowthColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Person> persons = FXCollections.observableArrayList();

        persons.add(new Person(0));
        persons.add(new Person(0.5));
        persons.add(new Person(1));

        levelOfGrowthColumn.setCellValueFactory(new PropertyValueFactory<Person, Double>("levelOfGrowth"));

    }
}