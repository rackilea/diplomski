import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{
    @FXML AnchorPane apMain;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try 
        {
            Pane newLoadedPane;

            Button tempButton = (Button)event.getSource();
            switch(tempButton.getId())
            {

                case "btnOne":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("viewOne.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
                case "btnTwo":
                    newLoadedPane =  FXMLLoader.load(getClass().getResource("viewTwo.fxml"));
                    apMain.getChildren().add(newLoadedPane);
                    break;
            }
        }
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

}