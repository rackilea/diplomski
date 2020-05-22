import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Test extends Application {

    Stage window;
    ListView<String> listView;
    TextArea descArea = new TextArea();
    TextArea actionDescArea = new TextArea();
    Label healthLabel = new Label("Health:");
    Label manaLabel = new Label("Mana:");
    Label healthDisplay = new Label("100/100");
    Label manaDisplay = new Label("100/100");
    Button actionBtn = new Button("Action");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Game");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        descArea.setPrefWidth(750);
        descArea.setPrefHeight(550);
        descArea.setWrapText(true);
        descArea.setEditable(false);
        GridPane.setConstraints(descArea, 0, 0, 2, 2);

        GridPane.setConstraints(healthLabel, 2, 0);
        GridPane.setValignment(healthLabel, VPos.TOP);

        GridPane.setConstraints(healthDisplay, 3, 0);
        GridPane.setValignment(healthDisplay, VPos.TOP);

        GridPane.setConstraints(manaLabel, 2, 1);
        GridPane.setValignment(manaLabel, VPos.TOP);

        GridPane.setConstraints(manaDisplay, 3, 1);
        GridPane.setValignment(manaDisplay, VPos.TOP);

        listView = new ListView<>();
        listView.getItems().addAll("Action 1", "Action 2", "Action 3", "Action 4");
        listView.setPrefWidth(260);
        listView.setMaxWidth(260);
        listView.setPrefHeight(150);
        GridPane.setConstraints(listView, 0, 2, 1, 1);

        actionDescArea.setPrefWidth(100);
        actionDescArea.setPrefHeight(150);
        actionDescArea.setWrapText(true);
        actionDescArea.setEditable(false);
        GridPane.setConstraints(actionDescArea, 1, 2, 1, 1);
        GridPane.setHgrow(actionDescArea, Priority.ALWAYS);

        actionBtn.setPrefWidth(260);
        actionBtn.setPrefHeight(60);
        GridPane.setConstraints(actionBtn, 0, 3);

        grid.getChildren().addAll(descArea, healthLabel, healthDisplay, manaLabel, manaDisplay, listView, actionBtn, actionDescArea);

        Scene scene = new Scene(grid, 950, 750);
        window.setScene(scene);
        window.show();
    }
}