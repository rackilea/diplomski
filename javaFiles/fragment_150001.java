import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CLSample extends Application {

    public static void main(String[] args) {

        if (Arrays.asList(args).contains("-cl")) {
            commandLine();
            Platform.exit();
        } else {
            launch(args);
        }

    }

    public static void commandLine() {
        System.out.println("Running only command line version...");
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        root.getChildren().add(new Label("GUI Loaded!"));

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("CLSample Sample");
        primaryStage.show();

    }
}