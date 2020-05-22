import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @see https://stackoverflow.com/a/38347332/230513
 */
public class ComboBoxTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ComboBoxTest");

        final TextField txtActivity = new TextField();
        final ComboBox cmbComponent = new ComboBox();
        ObservableList<Details> cmbComponentData = FXCollections.observableArrayList();
        cmbComponentData.add(new Details("Ministry of Water", "1.0.0"));
        cmbComponentData.add(new Details("Ministry of Lands", "2.0.0"));
        cmbComponentData.add(new Details("Ministry of Minerals", "3.0.0"));
        cmbComponentData.add(new Details("Ministry of ManKind", "4.0.0"));
        cmbComponent.setItems(cmbComponentData);
        cmbComponent.getSelectionModel().selectFirst();
        txtActivity.setText(cmbComponentData.get(0).getText());
        cmbComponent.valueProperty().addListener((o, ov, nv) -> {
            Details d = (Details) nv;
            txtActivity.setText(d.getText());
        });

        VBox root = new VBox();
        root.getChildren().addAll(cmbComponent, txtActivity);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class Details {

        private final StringProperty name;
        private final StringProperty text;

        public Details(String name, String text) {
            this.name = new SimpleStringProperty(name);
            this.text = new SimpleStringProperty(text);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public String getText() {
            return text.get();
        }

        public void setText(String text) {
            this.text.set(text);
        }

        public StringProperty textProperty() {
            return text;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}