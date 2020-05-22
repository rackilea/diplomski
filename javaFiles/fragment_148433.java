package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage window) throws Exception {
        // Database call goes here!
        DatabaseManager.initialize();


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Whatever window initialization stuff you need to do
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}