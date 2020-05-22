package RezRem;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

private static double xOffset = 0;
private static double yOffset = 0;
public static void main(String[] args) {

    launch(args);

}

@Override
public void start(Stage primaryStage) {

    Platform.setImplicitExit(false);


    Browser browser = new Browser();

    BrowserView browserView = new BrowserView(browser);
    StackPane pane = new StackPane();

    pane.getChildren().add(browserView);
    pane.setPadding(new Insets(10,10,10,10));
    Scene scene = new Scene(pane, 380, 500);

    primaryStage.initStyle(StageStyle.UNDECORATED);

    primaryStage.setScene(scene);

    pane.setOnMousePressed(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            System.out.println("mouse pressed");

            xOffset = primaryStage.getX() - event.getScreenX();

            yOffset = primaryStage.getY() - event.getScreenY();

        }

    });

    pane.setOnMouseDragged(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

            System.out.println("mouse dragged");

            primaryStage.setX(event.getScreenX() + xOffset);

            primaryStage.setY(event.getScreenY() + yOffset);

        }

    });
    browser.loadURL("http://www.google.com");
    primaryStage.show();

}

}