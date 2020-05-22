package de.professional_webworkx.jfx.twowindows.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class SecondController implements Initializable {

    @FXML
    AnchorPane mainPane;

    @FXML
    TextField textField;

    @FXML
    Button updateBtn;

    private FirstController firstController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String text = textField.getText();
                firstController.updateText(text);
                firstController.secondClosed();

            }
        });
    }

    public void setFirstController(final FirstController firstController) {
        this.firstController = firstController;
    }
}