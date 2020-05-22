import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollBarPercentage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Simple TextArea
        TextArea textArea = new TextArea() {{
            setWrapText(true);
            setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec suscipit posuere sodales. Mauris sodales velit vel sollicitudin volutpat. Sed rhoncus sodales sagittis. Duis ut congue mauris, sit amet tincidunt lacus. Mauris convallis convallis massa, in cursus nulla sollicitudin et. Etiam quis congue mi, nec tempor tellus. Praesent sed mollis ante. Curabitur fermentum volutpat massa, non dapibus tortor rutrum et. Sed lorem dui, pharetra ac lacus non, ultricies varius enim. Ut nec ante lectus. Vestibulum scelerisque vulputate facilisis. Cras commodo sapien eros, eu pellentesque massa congue vel. Aliquam urna neque, elementum iaculis justo eget, semper ullamcorper magna.\n\n" +
                    "Suspendisse ultricies porta auctor. Praesent ultrices lectus sed maximus ultricies. Nulla pharetra, augue in luctus fringilla, enim turpis auctor turpis, eu ullamcorper metus ligula ac nisl. Quisque accumsan tempus varius. Mauris blandit erat eget enim tempor accumsan. Nam iaculis libero a est sollicitudin, non fermentum ex viverra. Vivamus pharetra neque non augue feugiat efficitur. In hac habitasse platea dictumst. Aliquam tempor enim blandit blandit tempor. Ut porta ex sed congue maximus. Nulla non tortor est. Integer vel placerat lectus, vel tempus justo. Vestibulum ut dui sit amet mauris maximus ultricies vel in quam. Fusce suscipit volutpat magna eget ornare. Donec elementum ultricies tortor, volutpat porta enim fermentum sit amet.\n\n" +
                    "Aenean id erat at metus accumsan sodales. Suspendisse sed nisi iaculis, congue lectus et, efficitur nibh. Curabitur placerat erat et justo blandit porttitor. Nam mollis tempor magna, sed rutrum neque. Nunc mollis nunc posuere ex iaculis elementum. Nunc quam diam, aliquam ut ex mollis, facilisis varius ligula. Donec nec venenatis nunc, et auctor mi.");

        }};
        VBox.setVgrow(textArea, Priority.ALWAYS);

        // Label to display percentage scrolled
        Label label = new Label();

        // Since the lookup will only work after the TextArea has been rendered in the Scene, we need to retrieve it later with the runLater() method
        Platform.runLater(() -> {

            // Get the ScrollBar from the TextArea using a lookup
            ScrollBar scrollBar = (ScrollBar) textArea.lookup(".scroll-bar:vertical");

            // Now create a DoubleProperty that we'll bind to our scroll value * 100
            DoubleProperty scrollPercentage = new SimpleDoubleProperty();
            scrollPercentage.bind(Bindings.createDoubleBinding(() -> scrollBar.valueProperty().get() * 100, scrollBar.valueProperty()));

            // Bind the label to show a formatted percentage of the scrolling
            label.textProperty().bind(Bindings.format("%,.2f", scrollPercentage));

        });

        root.getChildren().addAll(textArea, new Label("Scrolled:"), label);

        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Sample");
        primaryStage.show();
    }
}