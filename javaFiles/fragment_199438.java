import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Charts extends Application {

    File file = null;

    @Override
    public void start(Stage stage) {

        Button chooseFile = new Button("Choose file");
        Button sendFile = new Button("Send file");
        Label fileLabel = new Label();
        Label label = new Label();
        FileChooser fileChooser = new FileChooser();

        chooseFile.setOnAction((ActionEvent e) -> {
            configureFileChooser(fileChooser);
            File tempFile = fileChooser.showOpenDialog(stage);
            if (tempFile != null) { 
                setFile(tempFile);
                fileLabel.setText("File : " + tempFile.getName() );
            } else {
                fileLabel.setText("No file Chosen");
            }
        });

        sendFile.setOnAction((ActionEvent e) -> {
            if (file != null) { 
                int response = sendFileToHTTP(file);
                label.setText("Response returned : " + String.valueOf(response));
            } else {
                label.setText("Please choose a file");
            }
        });


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        vBox.getChildren().addAll(chooseFile,fileLabel, sendFile, label);
        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void configureFileChooser(final FileChooser fileChooser) {                           
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                 new ExtensionFilter("Text Files", "*.txt"),
                 new ExtensionFilter("All Files", "*.*"));
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        ); 
    }

    private int sendFileToHTTP(File file) {
        int responseCode = 0;
        try {
            URL url = new URL("http://adirascala.site50.net/index.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
            //Set Request Type to POST
            conn.setRequestMethod("POST");
            //Send text data
            conn.setRequestProperty("Content-Type", "text/plain");

            //Replace the file-path with your local file-path
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer data = new StringBuffer();
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                data.append(tempLine);
            }
            br.close();

            // Send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(data.toString());
            wr.flush();
            wr.close();

            //Fetch Response Code
            responseCode = conn.getResponseCode();

            //Read the response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
        //Return the response code
        return responseCode;
    }

    private void setFile(File tempFile) {
        this.file = tempFile;
    }

    public static void main(String[] args) {
        launch();
    }

}