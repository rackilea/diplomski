import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ListViewExperiments extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("ListView Experiment 1");

        List<String> data = new ArrayList();
        data.add("CTAudSvc                2760");
        data.add("ctfmon                  6176");
        data.add("dllhost                 6464");

        ListView listView = new ListView();
        listView.setItems(FXCollections.observableArrayList(data));
        listView.setCellFactory(lv -> new ListCell<String>()
        {
            Label label = new Label();              
            Label label2 = new Label();
            HBox hBox = new HBox(label, label2);

            @Override
            public void updateItem(String item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                }
                else {
                    label.setMaxWidth(Double.MAX_VALUE);
                    HBox.setHgrow(label, Priority.ALWAYS);
                    String[] splitString = item.split("\\s+");
                    label.setText(splitString[0]);
                    label2.setText(splitString[1]);
                    setGraphic(hBox);
                }
            }
        });

        HBox hbox = new HBox(listView);

        Scene scene = new Scene(hbox, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}