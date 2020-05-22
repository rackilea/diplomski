public class ServeController implements Initializable {

    public ObservableList<String> pizzas1 = FXCollections.observableArrayList();

    @FXML
    public ComboBox<String> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().addAll(
                "jacob.smith@example.com",
                "isabella.johnson@example.com",
                "ethan.williams@example.com",
                "emma.jones@example.com",
                "michael.brown@example.com"
        );
    }
}