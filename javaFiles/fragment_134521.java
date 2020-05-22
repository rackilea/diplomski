package hidepopup;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    FXMLLoader loader;
    Parent root2;
    Stage stage2;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try
        {
            Scene scene2 = new Scene(root2);            
            stage2.setScene(scene2); 
            stage2.setTitle("second stage");
            stage2.showAndWait();
        }
        catch(IllegalArgumentException ex)
        {
            stage2.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try 
        {
            loader = new FXMLLoader(getClass().getResource("FXMLPopup.fxml"));
            root2 = loader.load();
            FXMLPopupController dac = (FXMLPopupController) loader.getController();
            stage2 = new Stage();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}