public class MyTablesController implements Initializable {

    @FXML
    private TableView<Pet> Table1;
    @FXML
    private TableView<Pet> Table2;
    @FXML
    private TableView<Pet> Table3;
    @FXML
    private TableView<Pet> Table4;

    private TableView<Pet>[] allTables;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        allTables = new TableView[4];
        allTables[0] = Table1;
        allTables[1] = Table2;
        allTables[2] = Table3;
        allTables[3] = Table4;

        for(TableView<Pet> table : allTables) {
            table.getColumns().add(createCol("ID", Pet::idProperty, 100));
            table.getColumns().add(createCol("Name", Pet::nameProperty, 140));
            table.getColumns().add(createCol("Owner", Pet::ownerProperty, 100));
            table.getItems().addAll(
                    new Pet("1234", "spot", "joe"),
                    new Pet("5432", "snowball", "bill"),
                    new Pet("7612", "snoopy", "frank")
            );
        }

        setupTableRowDragEvents();
    }

    // ...

}