import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Starter {
    public static void main(String[] args) {
        Platform.startup(() -> {});
        Platform.runLater(() -> {
            final GridPane gridPane = new GridPane();
            final Scene scene = new Scene(gridPane);
            final Stage stage = new Stage();
            stage.setScene(scene);

            final List<StackPane> panes = new ArrayList<>();
            for (int i = 0; i < 4; i++) {

                // Create a new pane with a random background color for
                // illustration
                final StackPane p = createNewPane();
                panes.add(p);

                // The addition / removal of the following line affects the
                // layout.
                p.setStyle("-fx-border-width:2px;-fx-border-color:red");
            }

            for (int r = 0; r < 2; r++) {
                final RowConstraints rc = new RowConstraints();
                rc.setPercentHeight(50);
                gridPane.getRowConstraints().add(rc);
            }
            for (int c = 0; c < 2; c++) {
                final ColumnConstraints cc = new ColumnConstraints();
                cc.setPercentWidth(50);
                gridPane.getColumnConstraints().add(cc);
            }

            for (int r = 0, i = 0; r < 2; r++) {
                for (int c = 0; c < 2; c++) {
                    gridPane.add(panes.get(i++), c, r);
                }
            }
            stage.show();
        });
    }

    private static final Random random = new Random(42);

    private static StackPane createNewPane() {
        StackPane pane = new StackPane();

        pane.setBackground(
                new Background(
                        new BackgroundFill(
                                randomColor(), null, null
                        )
                )
        );

        pane.setPrefSize(150, 100);

        return pane;
    }

    private static Color randomColor() {
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        );
    }
}