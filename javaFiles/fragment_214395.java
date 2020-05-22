import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
    private BorderPane root = new BorderPane();
    private Scene szene = new Scene(root);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ComboBox<String> comboBox = new ComboBox<String>();

        List<User> list = new ArrayList<User>();
        ObservableList<User> userList = FXCollections.observableList(list);
        userList.addListener(new ListChangeListener<Object>() {

            @Override
            public void onChanged(Change<?> change)
            {
                comboBox.getItems().clear();
                for(User u : userList)
                {
                    comboBox.getItems().add(u.getName());
                }
            }
        });

        userList.add(new User("Max", "Mustermann"));
        userList.add(new User("Adam", "Sandler"));
        userList.add(new User("Jan", "Boehmermann"));

        root.setCenter(comboBox);

        primaryStage.setScene(szene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}