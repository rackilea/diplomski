import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Foo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Menu fileMenu = new Menu("File");

        ChoiceBox<String> languageBox = new ChoiceBox<String>();
        languageBox.getItems().addAll("English", "Deutsch");

        Menu languageMenu = new Menu();
        languageMenu.setId("transparent");
        languageMenu.setGraphic(languageBox);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, languageMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("MCVE");
        stage.setWidth(640);
        stage.setHeight(480);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}