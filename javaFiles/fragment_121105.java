package home;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import template.Template;

public class Home extends Template {

    @FXML
    private Label welcomeLabel ;

    public Home() throws IOException {

        // not necessary to explicitly call super(), it is called by default
        // this call loads the template defined by the superclass
        super();

        FXMLLoader loader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        loader.setRoot(getCenterContentHolder());
        loader.setController(this);

        loader.load();

        welcomeLabel.setFont(Font.font("Arial", 48));
    }
}