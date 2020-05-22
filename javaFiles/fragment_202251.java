package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();
        MenuButton openButton = new MenuButton("Open Context Menu");
        BorderPane contentPane = new BorderPane();
        CustomMenuItem item = new CustomMenuItem(contentPane);
        openButton.setStyle("-fx-selection-bar: transparent;"); //this is optional. it makes the blue background that appears when something is focused transparent
        contentPane.setPrefSize(300, 300);
        Label text = new Label("The ContextMenu will only close when you click the\nbutton below OR click outside of the ContextMenu.\nHow neat is that?");
        text.setStyle(" -fx-text-fill: -fx-text-base-color;"); //needs to bet set if you want the selection-bar to be transparent. if not set the text will become invisible
        contentPane.setTop(text);
        Button closeButton = new Button("Close this popover");
        closeButton.setOnAction(x -> {
            openButton.hide();
        });
        contentPane.setBottom(closeButton);
        item.setHideOnClick(false); // this will stop the ContextMenu from being hidden when clicking inside of it.
        openButton.getItems().add(item);
        rootPane.setCenter(openButton);
        Scene scene = new Scene(rootPane, 550, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}