public class PersonView implements Initializable {
    @FXML
    TextField name;

    @FXML
    TextField age;

    @FXML
    Button ok;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PersonViewModel viewModel = new PersonViewModel();
        UnaryOperator<Change> filter = change -> {
            if (viewModel.validAgeInput(change.getControlNewText()) {
                // accept
                return change ;
            } else {
                // reject
                return null ;
            }
        };
        TextFormatter<Integer> ageFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, filter);
        age.setTextFormatter(ageFormatter);
        ageFormatter.valueProperty().bindBidirectional(viewModel.ageProperty().asObject());
        name.textProperty().bindBidirectional(viewModel.nameProperty());
    }
}