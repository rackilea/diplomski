import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;


public class BlockingThreadTestCase extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuItem menuItem = new MenuItem("Start");
        MenuButton menuButton = new MenuButton();
        menuButton.setText("Async Process");
        menuButton.getItems().addAll(menuItem);

        menuItem.setOnAction(event -> {
            menuButton.setText("Running...");

            Task task = new Task<Void>() {
                @Override
                public Void call() {
                    //SIMULATE A FILE DOWNLOAD
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            task.setOnSucceeded(taskFinishEvent -> menuButton.setText(menuButton.getText() + "Done!"));
            new Thread(task).start();
        });

        final ToolBar toolbar = new ToolBar(menuButton);
        final Scene scene = new Scene(toolbar);
        primaryStage.setScene(scene);
        primaryStage.setWidth(150);
        primaryStage.show();
    }
}