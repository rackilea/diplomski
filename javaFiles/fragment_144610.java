import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class FXMLDocumentController implements Initializable { // notice this


    @FXML
    private Button but0;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked the button!");
    }

    @Override // and this
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}