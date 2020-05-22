import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LibraryViewController extends Application
{

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("abcFxml.fxml"));
        AnchorPane pane = (AnchorPane) fxmlLoader.load();
        Scene scene = new Scene(pane);
        arg0.setScene(scene);
        arg0.show();

    }

    public static void main(String args[])
    {
        launch(args);
    }

}