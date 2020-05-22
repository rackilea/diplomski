import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FractionDisplay extends Application {
    private class Fraction extends VBox {
        private double offset;

        public Fraction(int numerator, int denominator) {
            init(numerator + "", denominator + "");
        }

        public Fraction(String numerator, String denominator) {
            init(numerator, denominator);
        }

        private void init(String numerator, String denominator) {
            setAlignment(Pos.CENTER);

            Text numeratorText   = new Text(numerator);
            Text denominatorText = new Text(denominator);

            offset = numeratorText.getBaselineOffset() * 1.5;

            double dividerWidth =
                    Math.max(
                            numeratorText.getLayoutBounds().getWidth(),
                            denominatorText.getLayoutBounds().getWidth()
                    ) + 6;

            Line divider = new Line(0, 1, dividerWidth, 1);
            divider.setStrokeWidth(2);

            getChildren().addAll(
                    numeratorText,
                    divider,
                    denominatorText
            );
        }

        public double getBaselineOffset() {
            return offset;
        }
    }

    @Override
    public void start(Stage stage) {
        TextFlow flow = new TextFlow(
                new Text("In mathematics, the infinite series "),
                new Fraction(1, 2),
                new Text(" - "),
                new Fraction(1, 4),
                new Text(" + "),
                new Fraction(1, 8),
                new Text(" - "),
                new Fraction(1, 16),
                new Text(" . . . "),
                new Text(" is a simple example of an alternating series that converges absolutely.")
        );
        flow.setPadding(new Insets(5));
        Scene scene = new Scene(flow, 300, 100);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}