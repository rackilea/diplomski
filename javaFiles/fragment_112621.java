import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            // create the menu bar with a menu and its items
            MenuBar menuBar = new MenuBar();
            Menu mainMenu = new Menu("Window");
            MenuItem browserItem = new MenuItem("browser");
            MenuItem imageItem = new MenuItem("image");
            MenuItem closeItem = new MenuItem("exit");
            // create some different contents for the center of the border pane
            Label imagePlaceHolder = new Label("IMAGE TO BE SHOWN");
            WebView browser = new WebView();
            WebEngine browserEngine = browser.getEngine();

            // set the actions for the different items
            closeItem.setOnAction(action -> {
                System.exit(0);
            });

            imageItem.setOnAction(action -> {
                root.setCenter(imagePlaceHolder);
            });

            browserItem.setOnAction(action -> {
                root.setCenter(browser);
                browserEngine.load("http://www.google.com");
            });

            // add items to the menu, then the menu to the menu bar
            mainMenu.getItems().addAll(closeItem, browserItem, imageItem);
            menuBar.getMenus().add(mainMenu);

            // set the scene
            Scene scene = new Scene(root,400,400);
            root.setTop(menuBar);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}