import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NamespaceAware extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.getNamespace().put("name", "Foobar");
        loader.setLocation(getClass().getResource("inclusions.fxml"));
        Pane content = loader.load();

        content.setPadding(new Insets(10));

        stage.setScene(new Scene(content));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}