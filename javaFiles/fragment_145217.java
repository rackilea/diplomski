import java.util.concurrent.CountDownLatch;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class ProgressTest extends Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        Button getButton = new Button("Copy");

        ProgressBar progressBar = new ProgressBar(0);
        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressBar.setProgress(0);
        progressIndicator.setProgress(0);
        Label statusLabel1 = new Label();
        Label statusLabel2 = new Label();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(statusLabel1, statusLabel2, progressBar, progressIndicator, getButton);
        vBox.setAlignment(Pos.CENTER);

        getButton.setOnAction((ActionEvent e) ->
        {

            CountDownLatch countDownLatch = new CountDownLatch(2);

            // Create a Task.
            CopyTask copyTask1 = new CopyTask(30, countDownLatch);
            CopyTask copyTask2 = new CopyTask(50, countDownLatch);
            progressBar.progressProperty().unbind();
            // Bind progress property
            progressBar.progressProperty().bind(copyTask2.progressProperty());

            progressIndicator.progressProperty().unbind();
            // Bind progress property.
            progressIndicator.progressProperty().bind(copyTask1.progressProperty());

            // Unbind text property for Label.
            statusLabel1.textProperty().unbind();
            statusLabel2.textProperty().unbind();

            // Bind the text property of Label
            // with message property of Task
            statusLabel1.textProperty().bind(copyTask1.messageProperty());
            statusLabel2.textProperty().bind(copyTask2.messageProperty());

            // When completed tasks
            copyTask1.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, (WorkerStateEvent t) ->
            {
                statusLabel1.textProperty().unbind();
                statusLabel1.setText("Finished1");
            });
            copyTask2.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, (WorkerStateEvent t) ->
            {
                statusLabel2.textProperty().unbind();
                statusLabel2.setText("Finished2");

            });

            Task<Void> task = new Task<Void>()
            {
                @Override
                public Void call() throws InterruptedException
                {

                    // Start the Task.
                    new Thread(copyTask1).start();
                    new Thread(copyTask2).start();
                    countDownLatch.await();
                    return null;

                }
            };

            task.setOnSucceeded(event ->
            {
                System.out.println("This occurs after both threads complete...");

            });

            task.setOnFailed(event ->
            {
                System.out.println("FAIL...");
            });

            Thread thread = new Thread(task);
            thread.start();

        });

        final Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public class CopyTask extends Task<Void>
    {

        int x;
        CountDownLatch latch;

        public CopyTask(int x, CountDownLatch latch)
        {
            super();
            this.x = x;
            this.latch = latch;

        }

        @Override
        protected Void call() throws Exception
        {
            //don't do the infitnite progress meter ...
            this.updateProgress(0, x);

            try
            {

                int len;
                for (len = 0; len <= x; len++)
                {
                    this.updateProgress(len, x);
                    Thread.sleep(100);
                    if (this.isCancelled())
                    {
                        throw new InterruptedException();
                    }
                }

                if (this.isCancelled())
                {
                    throw new InterruptedException();
                }
            } catch (InterruptedException ex)
            {
                System.out.println("Cancelled");
            }
            latch.countDown();
            return null;

        }

    }

}