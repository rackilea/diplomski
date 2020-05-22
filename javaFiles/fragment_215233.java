import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication22 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage passwordStage = getPasswordStage();
                passwordStage.initModality(Modality.APPLICATION_MODAL);//This is important if you don't want the user to interact with other windows
                passwordStage.initOwner(primaryStage);
                passwordStage.showAndWait();
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(new StackPane(new Label("Main Center")));
        root.setTop(new StackPane(new Label("Main Screen")));
        root.setRight(new StackPane(new Label("Main Right")));
        root.setLeft(new StackPane(new Label("Main Left")));
        root.setBottom(new StackPane(btn));

        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPasswordStage()
    {
        Stage stage = new Stage();

        TextField textField = new TextField();
        textField.setPromptText("Enter password here");

        Button button = new Button("login");
        button.setOnAction(e -> {
            if(textField.getText().equals("password"))
            {
                stage.close();
            }
        });


        VBox vbox = new VBox(new StackPane(textField), new StackPane(button));
        StackPane stackPane = new StackPane(vbox);
        Scene scene = new Scene(stackPane,300, 200);

        stage.setTitle("Login Screen");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        return stage;
    }

}