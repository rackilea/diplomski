import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class PrimaryController
{
    @FXML
    ProgressBar pbSplash;
    @FXML
    ProgressIndicator piSplash;


    public ProgressBar getPBSplashValue()
    {
        return pbSplash;
    }

    public ProgressIndicator getPISplash()
    {
        return piSplash;
    }

}