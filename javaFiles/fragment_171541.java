import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlowPaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        final FlowPane flow = new FlowPane();
        flow.getChildren().add(new Text("Starting "));
        Task task = new Task() {
            @Override protected Void call() throws Exception {
                //for (Object v : collection.getObjects()){
                for (int i = 0; i < 100; i++) {//use your loop instead
                    Platform.runLater(()->{
                        flow.getChildren().add(new Text("adding node "));
                    });
                    Thread.sleep(100);
                }
                return null;
            }
        };

        Scene scene = new Scene(flow, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }
}