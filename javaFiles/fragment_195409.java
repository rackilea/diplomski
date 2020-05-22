import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class TitledPaneApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TabPane subTabPane = new TabPane(new Tab("Sub tab1", new Label("Sub content1")), new Tab("Sub tab2", new Label("Sub content2")));
        TitledPane subTitledPane = new TitledPane("Sub titled pane", subTabPane);
        Accordion subAccordion = new Accordion(subTitledPane);

        Tab tab1 = new Tab("Tab1", subAccordion);
        Tab tab2 = new Tab("Tab2", new Label("Content2"));
        TabPane tabPane = new TabPane(tab1, tab2);
        TitledPane titledPane = new TitledPane("Titled pane", tabPane);
        Accordion accordion = new Accordion(titledPane);

        Scene scene = new Scene(accordion, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}