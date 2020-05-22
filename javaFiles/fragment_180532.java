package matchingcards;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MatchingCards extends Application {

    Stage window;
    Scene start, game;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        // When user clicks start, program enters game
        Button btn = new Button("Start Game");

        btn.setOnAction(e -> window.setScene(game));

        // Create the display for start button
        GridPane pane1 = new GridPane();
        pane1.getChildren().addAll(btn);
        start = new Scene(pane1, 200, 200);

        // Create display for game
        GridPane pane2 = new GridPane();
        Image back = new
                Image(
                "https://i.pinimg.com/736x/c1/59/b4/c159b4738dae9c9d8d6417228024de8d--" +
                "playing - card - design - card - card.jpg",
                300, 200, false, false);
        pane2.getChildren().addAll(new ImageView(back));
        game = new Scene(pane2, 500, 500);

        window.setScene(start);
        window.setTitle("Matching Cards");
        window.show();
    }
}