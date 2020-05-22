package sample;

import java.net.URL ;
import java.util.ResourceBundle ;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
    public Button btn_checkPSC;
    public Button btn_saveToCSV;
    public ScrollPane tbl_pane;
    public Button btn_insertRow;
    public Button btn_deleteAllSpace;
    public Button btn_1;
    public Button btn_2;
    public ProgressBar prgrs_bar;
    public TextField textarea;

    public Controller() {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonAction(javafx.event.ActionEvent actionEvent) {
        System.out.println("Working Handler");
    }
}