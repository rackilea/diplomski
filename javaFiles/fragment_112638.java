public class MyExampleController implements Initializable {

@FXML
private Label labLab;
@FXML
private Button btnButton;

@Override
public void initialize(URL url, ResourceBundle rb) {       
}    

@FXML
private void clickButton(ActionEvent event) {
    Test.getStage2().show();
}

public Label getLabel(){
    return labLab;
}
}