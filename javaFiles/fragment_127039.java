import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TwoForms extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane(); // TLC (Top Layer Container) a root container for all other components, which in your case is the Button 
        Button button = new Button("Go To Second Form"); // the button
        root.getChildren().add(button); // add the button to the root
        Scene scene = new Scene(root, 500,500); // create the scene and set the root, width and height
        primaryStage.setScene(scene); // set the scene
        primaryStage.setTitle("First Form");
        primaryStage.show();

        // add action listener, I will use the lambda style (which is data and code at the same time, read more about it in Oracle documentation)
        button.setOnAction(e->{
            //primaryStage.close(); // you can close the first stage from the beginning

            // create the structure again for the second GUI
            // Note that you CAN use the previous root and scene and just create a new Stage 
            //(of course you need to remove the button first from the root like this, root.getChildren().remove(0); at index 0)
            StackPane root2 = new StackPane();
            Label label = new Label("Your are now in the second form");
            root2.getChildren().add(label);
            Scene secondScene = new Scene(root2, 500,500);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene); // set the scene
            secondStage.setTitle("Second Form");
            secondStage.show();
            primaryStage.close(); // close the first stage (Window)
        });
    }

    public static void main(String[] args) {
        launch();

    }

}