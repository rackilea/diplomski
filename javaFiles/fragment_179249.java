package de.professional_webworkx.jfx.twowindows;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 */
public class TwoStages extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent load = FXMLLoader.load(getClass().getResource("firstWindow.fxml"));
            Scene scene = new Scene(load);

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TwoStages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}