import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.concurrent.Task;

/**
 * JavaFX App
 */
public class App extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        PrimaryController primaryController = loader.getController();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        final Task<DataModel> task = new Task<DataModel>(){
            @Override
            protected DataModel call() throws Exception
            {
                updateProgress(0, 3);
                DataModel dataModel = new DataModel();
                dataModel.loadListViewData();
                Thread.sleep(2000);
                updateProgress(1, 3);
                dataModel.loadComoBoxData();
                Thread.sleep(2000);
                updateProgress(2, 3);
                dataModel.loadTextAreaData();
                Thread.sleep(2000);
                updateProgress(3, 3);
                Thread.sleep(1000);

                return dataModel;
            }
        };

        task.setOnSucceeded((event) -> {             
            try
            {   
                FXMLLoader secondaryLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Stage secondaryStage = new Stage();
                Parent secondaryRoot = secondaryLoader.load();
                SecondaryController secondaryController = secondaryLoader.getController();
                secondaryController.initModel(task.getValue());
                secondaryStage.setTitle("Scene One");
                secondaryStage.setScene(new Scene(secondaryRoot, 500, 500));
                secondaryStage.show();
                primaryStage.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        });

        primaryController.getPBSplashValue().progressProperty().bind(task.progressProperty());
        primaryController.getPISplash().progressProperty().bind(task.progressProperty());

        new Thread(task).start();
    }

    public static void main(String[] args) {
        launch();
    }

}