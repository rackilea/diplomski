import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Item> choices = new ComboBox<>();
        for (int i = 1 ; i <=3 ; i++) {
            choices.getItems().add(new Item("Choice "+i, "These are the details for choice "+i));
        }

        Label label = new Label();

        choices.valueProperty().addListener((obs, oldItem, newItem) -> {
            label.textProperty().unbind();
            if (newItem == null) {
                label.setText("");
            } else {
                label.textProperty().bind(newItem.detailsProperty());
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(label);
        root.setTop(choices);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public class Item {
        private final String name ;
        private final StringProperty details = new SimpleStringProperty() ;

        public Item(String name, String details) {
            this.name = name ;
            setDetails(details) ;
        }

        public String getName() {
            return name ;
        }

        @Override
        public String toString() {
            return getName();
        }

        public final StringProperty detailsProperty() {
            return this.details;
        }


        public final String getDetails() {
            return this.detailsProperty().get();
        }


        public final void setDetails(final String details) {
            this.detailsProperty().set(details);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}