import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;

public class ProgressBarExample extends Application{

    ProgressBar pb = new ProgressBar(); // your progress bar


    @Override
    public void start(Stage primaryStage) throws Exception {

        // The structure and components are for example only
        TextField password = new TextField();
        Button test = new Button("Test");
        HBox container = new HBox();
        container.getChildren().addAll(password, test);
        container.setAlignment(Pos.CENTER);
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(container);


        // add action listener to the button
        test.setOnAction(e->{
            // when it's pressed add Progress bar and other stuff that are concerned with the GUI! 
            Platform.runLater(new Runnable(){ // always use this to update GUI components
                @Override
                public void run() {
                    root.getChildren().add(pb);
                    // you can add label to the root...etc
                    // or update your progress bar ..etc
                    // in a nutshell: anything needs to be updated in GUI.
                }
            });

            Task<Boolean> validatePassword = new Task<Boolean>(){ // always use Task to do complex-long calculations
                @Override
                protected Boolean call() throws Exception {
                    return validatePassword(password);  // method to validate password (see later)      
                }
            };

            validatePassword.setOnSucceeded(ee->{ // when Task finishes successfully
                System.out.println("Finished");
                root.getChildren().remove(pb); // remove the progress bar   
                if(!validatePassword.getValue()){
                  Alert alert = new Alert(AlertType.ERROR, "Wrong Password", ButtonType.OK);
                  alert.showAndWait();
                }
            });

            validatePassword.setOnFailed(eee->{ // if it fails
                 System.out.println("Failed");
                 root.getChildren().remove(pb); // remove it anyway                                 
            });

            new Thread(validatePassword).start(); // add the task to a thread and start it
        });

        Scene scene = new Scene(root, 300,300);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    // validate here in this method
    public static boolean validatePassword(TextField password){
        for(int i=0; i<99999; i++){ // suppose it is a long process
            System.out.println("Processing");
        }
        if(password.getText().equalsIgnoreCase("Invalid")){ // suppose it's invalid, just for testing
            return false
        }
        return true;
    }


    public static void main(String[] args) {
        launch();
    }   
}