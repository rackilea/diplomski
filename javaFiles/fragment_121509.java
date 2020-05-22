public class DialogController {

    private final ReadOnlyObjectWrapper<Person> selectedPerson = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<Person> selectedPersonProperty() {
        return selectedPerson.getReadOnlyProperty();
    }

    public final Person getSelectedPerson() {
        return selectedPersonProperty().get();
    }

    @FXML
    private Button okButton ;

    public void initialize() {
        okButton.setOnAction(selectedPerson.set(new Person(...)));
    }
}