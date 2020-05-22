public class JobController {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {        
        label.setText("This is the controller speaking");
    } 
}