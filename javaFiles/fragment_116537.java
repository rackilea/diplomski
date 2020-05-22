import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/** @see https://stackoverflow.com/q/44792148/230513 */
public class CustomMenuTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 320, 240);

        ComboBox<String> comboBox = new ComboBox<>();
        for (int i = 0; i < 50; i++) {
            comboBox.getItems().add("Value " + i);
        }
        CustomMenuItem comboMenuItem = new CustomMenuItem(comboBox, false);
        comboBox.getSelectionModel().select(0);
        comboBox.setVisibleRowCount(16);

        ObservableList<String> values = FXCollections.observableArrayList();
        for (int i = 0; i < 50; i++) {
            values.add("Value " + i);
        }
        ListView<String> listView = new ListView<>(values);
        CustomMenuItem listMenuItem = new CustomMenuItem(listView, false);

        MenuBar menuBar = new MenuBar();
        Menu comboMenu = new Menu("Combo Values");
        comboMenu.getItems().add(comboMenuItem);
        Menu listMenu = new Menu("List Values");
        listMenu.getItems().add(listMenuItem);
        menuBar.getMenus().addAll(comboMenu, listMenu);
        group.getChildren().addAll(menuBar);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}