import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadFileWithProgress extends Application {


    public static class CountingInputStream extends InputStream implements AutoCloseable {

        private long bytesRead = 0 ;

        private final InputStream stream ;

        public CountingInputStream(InputStream stream) {
            this.stream = stream ;
        }

        @Override
        public int read() throws IOException {
            int result = stream.read() ;
            if (result != -1) {
                bytesRead++;
            }
            return result ;
        }

        @Override
        public void close() throws IOException {
            stream.close();
        }

        public long getBytesRead() {
            return bytesRead ;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        TextField numLinesField = new TextField();

        FileChooser chooser = new FileChooser();

        Button create = new Button("Create File...");
        create.setOnAction(e -> {
            int numLines = Integer.parseInt(numLinesField.getText());
            File file = chooser.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    createFile(file.toPath(), numLines);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });

        Button loadFile = new Button("Load file");
        ProgressBar progress = new ProgressBar(0);
        loadFile.setOnAction(e -> {
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                Task<Map<String, String>> task = readFileTask(file.toPath());
                progress.progressProperty().bind(task.progressProperty());
                task.setOnSucceeded(evt -> new Alert(AlertType.INFORMATION, "File loaded", ButtonType.OK).showAndWait());
                task.setOnFailed(evt -> new Alert(AlertType.ERROR, "File could not be loaded", ButtonType.OK).showAndWait());
                new Thread(task).start();
            }
        });

        root.addRow(0, new Label("Number of lines:"), numLinesField, create);
        root.add(loadFile, 0, 1, 3, 1);
        root.add(progress, 0, 2, 3, 1);

        GridPane.setFillWidth(progress, true);
        GridPane.setHalignment(progress, HPos.CENTER);
        GridPane.setFillWidth(loadFile, true);
        GridPane.setHalignment(loadFile, HPos.CENTER);

        root.setPadding(new Insets(20));
        root.setHgap(5);
        root.setVgap(10);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Task<Map<String, String>> readFileTask(Path path) {

        return new Task<Map<String, String>>() {

            @Override
            protected Map<String, String> call() throws IOException {
                try (
                        CountingInputStream input = new CountingInputStream(Files.newInputStream(path));
                        BufferedReader in = new BufferedReader(new InputStreamReader(input));
                    ) {

                        long totalBytes = Files.size(path);

                        return in.lines()
                                .peek(line -> updateProgress(input.getBytesRead(), totalBytes))
                                .map(line -> line.split("\t"))
                                .collect(Collectors.toMap(tokens -> tokens[0], tokens -> tokens[1]));
                    }

            }

        };

    }

    private void createFile(Path path, int numEntries) throws IOException {
        try (BufferedWriter out = Files.newBufferedWriter(path)) {
            for (int i = 1; i <= numEntries ; i++) {
                out.write(String.format("key %d\tvalue %d%n", i, i));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}