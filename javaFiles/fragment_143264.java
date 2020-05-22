package stackoverflow;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class TestController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    @Override public void initialize(URL location, ResourceBundle resources) {
        List<String> strings = new ArrayList<>();
        strings.add("Test1");
        strings.add("Test2");
        comboBox.setItems(FXCollections.observableArrayList(strings));
    }

}