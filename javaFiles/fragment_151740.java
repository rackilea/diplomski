import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ComputationSimulation extends Application {

    @Override
    public void start(Stage primaryStage) {

        // text fields for input:

        TextField xInput = new TextField();
        TextField yInput = new TextField();

        // Service for performing the computation.
        // (For demo here, the computation just computes the sum of 
        // the two input values. Obviously this doesn't take long, so 
        // a random pause is inserted.)

        Service<Integer> service = new Service<Integer>() {

            @Override
            protected Task<Integer> createTask() {

                final int x = readTextField(xInput);
                final int y = readTextField(yInput);

                return new Task<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        // simulate long-running computation...
                        Thread.sleep((int)(Math.random() * 2000) + 1000);

                        // this doesn't really take much time(!):
                        return x + y ;
                    }
                };
            }

        };

        // Label to show result. Just use binding to bind to value of computation:
        Label result = new Label();
        result.textProperty().bind(service.valueProperty().asString());

        // Button starts computation by restarting service:
        Button compute = new Button("Compute");
        compute.setOnAction(e -> service.restart());

        // Pane to hold controls:
        GridPane pane = new GridPane();
        // Disable pane (and consequently all its children) when computation is running:
        pane.disableProperty().bind(service.runningProperty());

        // layout etc:
        pane.setHgap(5);
        pane.setVgap(10);
        pane.addRow(0, new Label("x:"), xInput);
        pane.addRow(1, new Label("y:"), yInput);
        pane.addRow(2, new Label("Total:"), result);
        pane.add(compute, 1, 3);

        ColumnConstraints left = new ColumnConstraints();
        left.setHalignment(HPos.RIGHT);
        left.setHgrow(Priority.NEVER);
        pane.getColumnConstraints().addAll(left, new ColumnConstraints());
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // converts text in text field to an int if possible
    // returns 0 if not valid text, and sets text accordingly
    private int readTextField(TextField text) {
        try {
            return Integer.parseInt(text.getText());
        } catch (NumberFormatException e) {
            text.setText("0");
            return 0 ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}