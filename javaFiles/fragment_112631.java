public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private StackPane myStackPane;

    private Label label = new Label("Text 1");

    @FXML
    private void handleButtonAction(ActionEvent event) {

        FXMLLoader secondLoader = new FXMLLoader();
        secondLoader.setLocation(getClass().getResource("FXMLSecond.fxml"));

        try {
            secondLoader.load();
        } catch (IOException e) {e.printStackTrace();  }

        FXMLSecondController secondController = secondLoader.getController();
        //secondController.setFieldText(label.getText());
        secondController.setTextProperty(label.textProperty());

        Parent p = secondLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
        myStackPane.getChildren().add(label);
    }

    /*
    public void putLabelOnStackPane(String value) {
        label.setText(value);

        myStackPane.getChildren().add(label);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) { //no need to implement Initializable 
                                                         //if initialize not used 
    }    
}