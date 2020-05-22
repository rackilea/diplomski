package de.professional_webworkx.jfx.twowindows.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class FirstController implements Initializable {

    @FXML
    Button openBtn;

    @FXML
    TextField textField;

    private boolean secondOpen;
    private Stage secondStage;

    FirstController firstController;
    public FirstController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.firstController = this;
        System.out.println(firstController);
        openBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(!secondOpen) {
                    openBtn.setDisable(true);
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
                        Parent load = loader.load();
                        SecondController controller = (SecondController) loader.getController();
                        controller.setFirstController(firstController);
                        Scene scene = new Scene(load);
                        secondStage = new Stage();
                        secondStage.setScene(scene);
                        secondStage.show();
                        secondOpen = true;
                    } catch (IOException ex) {
                        Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    public void updateText(final String text) {
        this.textField.setText(text);
    }

    public void secondClosed() {
        this.secondOpen = false;
        this.openBtn.setDisable(false);
        secondStage.close();
    }
}