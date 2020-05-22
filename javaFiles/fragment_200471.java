import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class FancyTabPane extends TabPane {
    public FancyTabPane() {
        Tab newTabTab = new Tab();
        newTabTab.setClosable(false);
        Label addLabel = new Label("\u2795");
        addLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent paramT) {
                System.out.println("mouse click");
                addTab();
            }
        });
        /*
         * getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
         * @Override
         * public void changed(ObservableValue<? extends Tab> paramObservableValue, Tab paramT1, Tab
         * paramT2) {
         * System.out.println("model");
         * if (paramT1 == newTabTab) {
         * System.out.println("tab");
         * addTab();
         * }
         * }
         * });
         */
        newTabTab.setGraphic(addLabel);
        getTabs().add(newTabTab);
    }

    public void addTab() {
        RenamableTab newTab = new RenamableTab();
        getTabs().add(getTabs().size() - 1, newTab);
        getSelectionModel().select(newTab);
        newTab.rename();
    }
}