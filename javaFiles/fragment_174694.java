public class Controller {
    @FXML
    private ListView<Email> listView;
    private DataModel model = new DataModel();

    @FXML
    private void initialize() {
         List<Email> emailList = model.loadData();
         listView.getItems().addAll(emailList);
    }
}