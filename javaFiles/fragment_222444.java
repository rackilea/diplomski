package tests;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCustomLabel extends Application {

    @Override public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
        root.getStylesheets().add(getClass().getResource("Root.css").toExternalForm());
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}