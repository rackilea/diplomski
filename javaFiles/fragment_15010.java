import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ComboBoxConverter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        ComboBox<Sector> comboBox = new ComboBox<>();
        StringConverter<Sector> converter = new StringConverter<Sector>() {
            @Override
            public String toString(Sector object) {
                return object.getTitle();
            }

            @Override
            public Sector fromString(String string) {
                return null;
            }
        };
        comboBox.setConverter(converter);

        comboBox.setItems(FXCollections.observableArrayList(new Sector("Title1", 24), new Sector("Title2", 50)));
        comboBox.getSelectionModel().selectFirst();
        VBox box = new VBox(comboBox);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}