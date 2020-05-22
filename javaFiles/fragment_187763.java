import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create the ChoiceBox
        ChoiceBox<Course> cbCourses = new ChoiceBox<>();

        // Sample list of Courses
        ObservableList<Course> coursesList = FXCollections.observableArrayList();

        // Set the list of Course items to the ChoiceBox
        cbCourses.setItems(coursesList);

        // Add the ChoiceBox to our root layout
        root.getChildren().add(cbCourses);

        // Now, let's add sample data to our list
        coursesList.addAll(
                new Course("Math"),
                new Course("History"),
                new Course("Science"),
                new Course("Geography")
        );

        // Now we can select our value. For this sample, we'll choose the 3rd item in the coursesList
        cbCourses.setValue(coursesList.get(2));

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}