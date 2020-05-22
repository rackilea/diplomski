import javafx.application.*;
import java.text.*;
import java.util.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.geometry.*;

 public class Display extends Application{

public static void main(String[] args){
    launch(args);
}

@Override
public void start(Stage stage) throws Exception{


    HBox root = new HBox(); 

    Button button = new Button("button");
    Label  label = new Label("Label");

    root.getChildren().addAll(button, label);

    Scene scene = new Scene(root, 700,300);
    scene.getStylesheets().add("Style.css");
    stage.setScene(scene);

    stage.setTitle("Title");

    stage.show();
  }
}