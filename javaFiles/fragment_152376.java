package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Main extends Application {

private String alphabet = "abcdefghijklmnopqrstuvwxyz";
private Label lastLabel = new Label("");

@Override
public void start(Stage primaryStage) {
    try {
        VBox root = new VBox();
        Button btnAdd = new Button("Add label");
        final TilePane tilePane = new TilePane();

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Label lbl = new Label(lastLabel.getText()
                        + alphabet.charAt(lastLabel.getText().length()));
                tilePane.getChildren().add(lbl);
                lastLabel = lbl;
            }
        });

        root.getChildren().add(btnAdd);
        root.getChildren().add(tilePane);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(
                getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    launch(args);
    }
}