package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private GridPane gridPane;

    private Pane paneContainer;
    private Label paneLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i<4; i++) {

            paneLabel = new Label();
            paneLabel.setText("it is..." + i);

            paneContainer = new Pane();
            paneContainer.setStyle("-fx-background-color: aqua; -fx-border-style: solid; -fx-border-width: 1px; -fx-border-color:#000; ");
            paneContainer.setPrefWidth(200);
            paneContainer.setPrefHeight(100);

            paneContainer.getChildren().add(paneLabel);
            gridPane.add(paneContainer, 0, i);
        }
    }
}