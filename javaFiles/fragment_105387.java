package application;

import java.io.IOException;
import java.net.URL;
import java.util.Map ;
import java.util.HashMap ;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{

    private Map<String, Tab> openTabs = new HashMap<>();

    @FXML
    private TabPane myTabPane ;
    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private Button btnTab1 ;
    @FXML
    private Button btnTab2 ;
    @FXML
    private Button btnTab3 ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnTab1.setOnAction(e -> openTab("MyTestTab.fxml"));
        btnTab2.setOnAction(e -> openTab("MyTestTab2.fxml"));
    }

    private void openTab(String fxmlFile) {
        if (openTabs.containsKey(fxmlFile)) {
            myTabPane.getSelectionModel().select(openTabs.get(fxmlFile));
        } else {
            try {               
                Tab myNewTab = FXMLLoader.load(this.getClass().getResource(fxmlFile));
                myTabPane.getTabs().add(myNewTab);
                openTabs.put(fxmlFile, myNewTab);
                myNewTab.setOnClosed(e -> openTabs.remove(fxmlFile));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }           
        }
    }
}