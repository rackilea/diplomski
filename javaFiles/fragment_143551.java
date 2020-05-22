import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXTest6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        final AnchorPane root = new AnchorPane();
        final TabPane tabs = new TabPane();
        final Button addButton = new Button("Btn1");
        addButton.setPrefWidth(41);
        addButton.setPrefHeight(15);

        AnchorPane.setTopAnchor(tabs, 5.0);
        AnchorPane.setLeftAnchor(tabs, 5.0);
        AnchorPane.setRightAnchor(tabs, 5.0);
        AnchorPane.setTopAnchor(addButton, 10.0);
        AnchorPane.setRightAnchor(addButton, 10.0);
        tabs.setStyle("-fx-padding: 2 0 0 50;");

        Tab tab = new Tab("Tab 1");
        Tab tab1 = new Tab("Tab 2");
        Tab tab2 = new Tab("Tab 3");

        tabs.getTabs().add(tab);
        tabs.getTabs().add(tab1);
        tabs.getTabs().add(tab2);

        root.getChildren().addAll(tabs, addButton);

        final Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Tabs with button !");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}