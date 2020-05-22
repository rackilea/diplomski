package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TitleSettingController implements PrimaryStageAware {
    private Stage stage ;

    @FXML
    private TextField titleField ;

    @Override
    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage ;
    }

    public void initialize()  {
        updateTitle("Initial title");
        titleField.textProperty().addListener((obs, oldTitle, newTitle) -> updateTitle(newTitle));
    }

    private void updateTitle(String title) {
        if (stage != null) {
            stage.setTitle(title);
        } else {
            System.out.println("Warning: null stage");
        }
    }

}