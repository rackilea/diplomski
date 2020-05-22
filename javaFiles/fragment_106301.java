JFXComboBox<String> combobox;

private ObservableList<String> list = FXCollections.observableArrayList();

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    Connection conn = SQLConnection.getConnection();

    fillListFromDataBase (conn, list);
    combobox.setItems(list);
}