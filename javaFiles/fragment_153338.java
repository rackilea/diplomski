public class ParentController {
    ...
    @FXML
    ComboBox comboBox;  

    private ObservableList parentList = FXCollections.observableArrayList();

    public void initialize() {
       comboBox.setItems(parentList);
       Bindings.bindContentBidirectional(parentList, childController.getChildList());
    }
    ...
}