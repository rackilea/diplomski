package be.pbeckers.javafxguiupdater.test;

import be.pbeckers.javafxguiupdater.GUIUpdater;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXTest extends Application {
    private Label       lblCurFile      =   new Label();
    private Label       lblErrors       =   new Label();
    private Label       lblBytesParsed  =   new Label();
    private ProgressBar prgProgress     =   new ProgressBar();

    public static void main(String args[]) {
        JavaFXTest.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Init window:
        FlowPane    flowPane = new FlowPane();
        primaryStage.setScene(new Scene(flowPane));
        primaryStage.setTitle("JavaFXTest");

        // Add a few Labels and a progressBar:
        flowPane.getChildren().add(this.lblCurFile);
        flowPane.getChildren().add(this.lblErrors);
        flowPane.getChildren().add(this.lblBytesParsed);
        flowPane.getChildren().add(this.prgProgress);

        // Add button:
        Button  btnStart = new Button("Start");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Create task:
                TestTask    testTask = new TestTask();

                // Bind:
                GUIUpdater.bind(JavaFXTest.this.lblCurFile.textProperty(), testTask.curFileProperty());
                GUIUpdater.bind(JavaFXTest.this.lblErrors.textProperty(), testTask.errorsProperty());
                GUIUpdater.bind(JavaFXTest.this.lblBytesParsed.textProperty(), testTask.bytesParsedProperty());
                JavaFXTest.this.prgProgress.progressProperty().bind(testTask.progressProperty());   // No need to use GUIUpdater here, Task class provides the same functionality for progress.

                // Start task:
                Thread  tmpThread = new Thread(testTask);
                tmpThread.start();
            }
        });
        flowPane.getChildren().add(btnStart);

        // Show:
        primaryStage.show();
    }

    /**
     * A simple task containing a for loop to simulate a fast running and fast updating process.
     * @author DePhille
     *
     */
    private class TestTask extends Task<Void> {
        private SimpleStringProperty    curFile     =   new SimpleStringProperty();
        private SimpleStringProperty    errors      =   new SimpleStringProperty();
        private SimpleStringProperty    bytesParsed =   new SimpleStringProperty();

        @Override
        protected Void call() throws Exception {

            // Count:
            try {
                int maxValue = 1000000;
                long startTime = System.currentTimeMillis();

                System.out.println("Starting...");
                for(int i = 0; i < maxValue; i++) {
                    this.updateProgress(i, maxValue - 1);

                    // Simulate some progress variables:
                    this.curFile.set("File_" + i + ".txt");
                    if ((i % 1000) == 0) {
                        //this.errors.set("" + (i / 1000) + " Errors");
                    }
                    //this.bytesParsed.set("" + (i / 1024) + " KBytes");
                }
                long stopTime = System.currentTimeMillis();
                System.out.println("Done in " + (stopTime - startTime) + " msec!");
            } catch(Exception e) {
                e.printStackTrace();
            }

            // Unbind:
            GUIUpdater.unbind(JavaFXTest.this.lblCurFile.textProperty(), this.curFileProperty());
            GUIUpdater.unbind(JavaFXTest.this.lblErrors.textProperty(), this.errorsProperty());
            GUIUpdater.unbind(JavaFXTest.this.lblBytesParsed.textProperty(), this.bytesParsedProperty());
            return null;
        }

        public SimpleStringProperty curFileProperty() {
            return this.curFile;
        }

        public SimpleStringProperty errorsProperty() {
            return this.errors;
        }

        public SimpleStringProperty bytesParsedProperty() {
            return this.bytesParsed;
        }

    }

}