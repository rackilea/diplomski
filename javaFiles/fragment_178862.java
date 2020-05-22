public class MainController implements Initializable{
    @FXML
    protected Label     myLabel;

    @FXML
    private Button loadChild;

    @FXML
    private AnchorPane  childContainer;

    @FXML
    protected Button    updateButton;

    StringProperty myStringProp=new SimpleStringProperty();


    private void loadChildpanel() {
        System.out.println(this.hashCode());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Child.fxml"));
        Node childNode;
        try {
            loader.setController(this);
            childNode = (Node) loader.load();
            childContainer.getChildren().add(childNode);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    private void updateLabel() {
        myStringProp.setValue("updated text");
        System.out.println(this.hashCode());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myStringProp.set("Initial text");
        loadChild.setOnAction(e->loadChildpanel());
        myLabel.textProperty().bind(myStringProp);

        if(updateButton!=null)updateButton.setOnAction(e->updateLabel());
    }

}