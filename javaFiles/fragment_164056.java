import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication4 extends Application {



    @Override
    public void start(Stage primaryStage) {
        ListView lvMain = new ListView();//Create ListView  
        lvMain.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//Change ListView selection mode to multiple

        ObservableList<String> items = FXCollections.observableArrayList("Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");//ObseravableList that will be used to set the ListView
        lvMain.setItems(items);//Set the ListView's items

        List<String> list = new ArrayList();//List that will hold potential items that are in the ListView
        list.add("Sue");//Add Sue to List
        list.add("Stephan");//Add Stephan to List



        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                //When the Button is pressed, loop through the list checking it's items against the ObservableList's items.
                for(String entry : list)
                {
                    for(String itemEntry : items)
                    {
                        if(entry.equals(itemEntry))//If the items are equal 
                        {
                            lvMain.getSelectionModel().select(itemEntry);//select the item in the ListView
                            break;//If you have duplicates in the ListView remove this line!
                        }
                    }
                }


            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lvMain, btn);


        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}