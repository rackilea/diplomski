public class Controller implements Initializable {

  @FXML private TableView<TableModel> tableView;

  @FXML private TableColumn<TableModel, String> nameColumn;

  @FXML private ObservableList<TableModel> dataArray;

  @Override public void initialize(URL location, ResourceBundle resources) {

    //add data to Observable List
    dataArray = FXCollections.observableArrayList(new TableModel("hello"), new TableModel("goodbye"));

    //crete one column, name "greetings" is the same name property which is in TableModel
    nameColumn.setCellValueFactory(new PropertyValueFactory<TableModel, String>("greetings"));

    tableView.setItems(dataArray);
  }

  public static class TableModel {

    StringProperty greetings = new SimpleStringProperty();

    public TableModel(String greetings) {
      this.greetings = new SimpleStringProperty(greetings);
    }

    public String getGreetings() {
      return greetings.get();
    }

    public StringProperty greetingsProperty() {
      return greetings;
    }

    public void setGreetings(String greetings) {
      this.greetings.set(greetings);
    }
  }

}