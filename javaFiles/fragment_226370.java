import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TextFieldAutoAppend extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Map<String, String> mapOfTasks = new HashMap<String, String>();
        mapOfTasks.put("1", "go to school");
        mapOfTasks.put("2", "good day");

        Pane pane = new Pane();
        TextField textField = new TextField();
        pane.getChildren().add(textField);

        textField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                String[] subStrings = newValue.split(" ");
                if(subStrings.length ==2){
                    if(subStrings[0].equalsIgnoreCase("edit") && mapOfTasks.keySet().contains(subStrings[1])){
                        textField.setText(newValue + " " + mapOfTasks.get(subStrings[1]));
                    }
                }
            }
        });

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}