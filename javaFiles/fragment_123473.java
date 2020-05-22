import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HideAndShowPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        Button button = new Button("Click Me to hide Pane !");
        Pane pane = new Pane();

        button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Hide the Pane
                    pane.setVisible(false);
                    //Schedule the Visibility for 1000ms
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                          @Override
                          public void run() {
                              //Run on UI thread
                              Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    pane.setVisible(true);                                  
                                }
                            });
                          }
                        }, 1000);   
                }
        });

        pane.setPrefSize(200, 200);
        pane.setStyle("-fx-background-color : PINK");
        stackPane.getChildren().addAll(pane, button);
        Scene scene = new Scene(stackPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}