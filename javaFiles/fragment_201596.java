package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleSetter.fxml"));
            loader.setControllerFactory((Class<?> type) -> {
                try {
                    Object controller = type.newInstance();
                    if (controller instanceof PrimaryStageAware) {
                        ((PrimaryStageAware) controller).setPrimaryStage(primaryStage);
                    }
                    return controller ;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            HBox root = loader.load();
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}