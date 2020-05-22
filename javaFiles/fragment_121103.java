package template;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Template extends BorderPane {

    @FXML
    private VBox vboxCenter ;

    public Template() throws IOException {
        FXMLLoader loader = new FXMLLoader(Template.class.getResource("Template.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }

    protected final VBox getCenterContentHolder() {
        return vboxCenter ;
    }

    @FXML
    private void quit() {
        vboxCenter.getScene().getWindow().hide();
    }
}