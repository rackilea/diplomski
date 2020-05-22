import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.geometry.Pos;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.HBox;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class HboxController implements Initializable {

    @FXML
    private HBox hBox;

    @FXML
    private TextField textfield1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hBox.setAlignment(Pos.CENTER);
    }
}