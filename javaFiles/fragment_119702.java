public class Controller {

    @FXML
    private ListView<Label> listView;
    private ObservableList<Label> yourList;

    public void initialize() {
        yourList = FXCollections.observableArrayList();
        listView.setItems(yourList);
    }

    public void onButtonPressed(){

        // You can do really bigger processing here

        Label label = new Label();
        label.setText("some text maybe");
        label.setPadding(new Insets(10));
        yourList.add(label);
    }
}