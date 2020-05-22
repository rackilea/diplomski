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

        // New code START

        // In case we have multiple columns with percent-values it
        // might come in handy to store our formatter
        Callback<TableColumn, TableCell> percantageCellFactory =
            new Callback<TableColumn, TableCell>() {
                public TableCell call(TableColumn p) {
                    return new PercantageFormatCell();
                }
            };

        // Now all we have to do is to apply it
        levelOfGrowthColumn.setCellFactory(percantageCellFactory);

        // New code END

        levelOfGrowthColumn.setCellValueFactory(new PropertyValueFactory<Person, Double>("levelOfGrowth"));

    }
}