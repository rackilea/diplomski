import java.util.stream.Stream;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

    private static ColumnConstraints[] createColumnConstraints() {
        return Stream.generate(() -> {
            var constraint = new ColumnConstraints();
            constraint.setHalignment(HPos.CENTER);
            constraint.setPercentWidth(100.0 / 3.0);
            constraint.setPrefWidth(225.0); // SET PREF WIDTH
            return constraint;
        }).limit(3).toArray(ColumnConstraints[]::new);
    }

    private static Rectangle[] createRectangles() {
        return Stream.generate(() -> new Rectangle(100.0, 150.0)).limit(3).toArray(Rectangle[]::new);
    }

    private static Label[] createLabels(String... texts) {
        return Stream.of(texts).map(text -> {
            var label = new Label(text);
            label.setWrapText(true);
            label.setTextAlignment(TextAlignment.CENTER);
            return label;
        }).toArray(Label[]::new);
    }

    @Override
    public void start(Stage primaryStage) {
        var root = new GridPane();
        root.setGridLinesVisible(true); // FOR VISUAL CLARITY
        root.setHgap(10.0);
        root.setVgap(10.0);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20.0));
        root.getColumnConstraints().addAll(createColumnConstraints());

        root.addRow(0, createRectangles());
        root.addRow(1, createLabels("Label A", "This is long text. ".repeat(10), "Label C"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}