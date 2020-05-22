package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Polygon;

    public class MainControl implements Initializable {
@FXML
Polygon player_ship;
@FXML
TextField textBox;
public void initialize(URL arg0, ResourceBundle arg1) {
 textBox.setPromptText("Write here");

    textBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
            System.out.println("Key Pressed: " + ke.getText());
        }
    });

    textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
            System.out.println("Key Released: " + ke.getText());
    if(ke.getText().equalsIgnoreCase("b")){
                System.out.println("Yay!");
    //What you want the computer to do goes here!
            }
        }
    });
}