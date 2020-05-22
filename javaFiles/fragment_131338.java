import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();

        ObservableList<Course> options = FXCollections.observableArrayList(
                        new Course(0, "JavaFX"),
                        new Course(1, "Swing"),
                        new Course(2, "Objective C"),
                        new Course(3, "Swift")
        );
        ComboBox<Course> comboBox = new ComboBox<Course>(options);
        comboBox.setCellFactory(new Callback<ListView<Course>, ListCell<Course>>() {
            @Override
            public ListCell<Course> call(ListView<Course> courses) {
                return new CourseCell();
            }
        });
        comboBox.setButtonCell(new CourseCell());

        Button btn = new Button();
        btn.setText("Use");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Course course = comboBox.getValue();
                if (course != null) {
                    System.out.println(course);
                    System.out.println(course.getId());
                }
            }
        });

        GridPane.setHalignment(comboBox, HPos.CENTER);
        GridPane.setHalignment(btn, HPos.CENTER);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(comboBox, 0, 0);
        gridPane.add(btn, 0, 1);

        Scene scene = new Scene(gridPane, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class CourseCell extends ListCell<Course> {

        @Override
        protected void updateItem(Course item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setText(item.getTitle());
            } else {
                setText(null);
            }
        }
    }

    public class Course {

        private long id;
        private String title;

        public Course(long id, String title) {
            this.id = id;
            this.title = title;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Course{" + "id=" + id + ", title=" + title + '}';
        }

    }

}