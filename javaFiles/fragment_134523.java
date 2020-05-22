package hidepopup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLPopupController implements Initializable {

    @FXML
    public Label label;

    @FXML
    private void handleButtonAction(ActionEvent event){        
        label.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
}