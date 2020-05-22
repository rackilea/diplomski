import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.management.PlatformManagedObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Example extends Application {
private  Scene myscene;
private TextArea exampleText;
public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
    //JavaFX boilerplate
    VBox rootVBox =  new VBox();
    exampleText = new TextArea();
    VBox.setVgrow(exampleText, Priority.ALWAYS);
    myscene = new Scene(rootVBox);
    rootVBox.getChildren().add(exampleText);
    //End of JavaFX boilerplate

    // Scheduler to update gui periodically
    ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();

    Random r = new Random();


    Runnable addNewNumber = () -> {
        Platform.runLater(()->{
            System.out.println("I Just updated!!!");
            String newNumber = Integer.toString(r.nextInt(100));
            System.out.println("adding "+ newNumber +"  to textfield ");
        exampleText.appendText(newNumber+"\n");
        });
    };



    executor.scheduleAtFixedRate(addNewNumber, 0, 500, TimeUnit.MILLISECONDS);
    primaryStage.setScene(myscene);
    primaryStage.show();

}