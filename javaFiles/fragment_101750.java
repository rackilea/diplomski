package application;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainController {
    @FXML
    private BorderPane root ;

    public void initialize() {
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    }
}