public class FXMLDocumentController {

    @FXML
    private ChoiceBox<String> pilot;

    public void initialize(){  

         setMembersList();
    }


    private void setMembersList(){
        List<String> list = new ArrayList<String>();
        list.add("Item A");
        list.add("Item B");
        list.add("Item C");
        ObservableList<String> obList = FXCollections.observableList(list);
        pilot.setItems(obList);
    }
}