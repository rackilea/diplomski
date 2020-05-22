import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        button.setDefaultButton(true);
    }
}