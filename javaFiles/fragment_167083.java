import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerLogin {

    @FXML TextField userNameField;
    @FXML PasswordField passwordField;

    private ModelLogin model;
    private Main main;

    @FXML
    void initialize() {
        model = new ModelLogin("test", "1234");
    }

    public void login(ActionEvent event) {

        if (model.isCorrectCredentials(userNameField.getText(), passwordField.getText() )) {

            try {
                main.startApp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Try again");
        }
    }

    void setMain(Main main) {
        this.main = main;
    }
}