import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;


public class FXEventFiltering extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(final Stage stage) throws Exception {
        //All the controls are added here
        VBox box = new VBox();
        ComboBox<String> dropdown = new ComboBox<>();
        TextField field = new TextField();
        CheckBox check = new CheckBox("Check");
        RadioButton radio = new RadioButton("Radio!");
        TextArea area = new TextArea();
        TableView<String> table = new TableView<String>(FXCollections.observableArrayList(new String[]{"one","two"}));
        TableColumn<String, String> tc = new TableColumn<String, String>("Column1");
        tc.setEditable(true);
        tc.setCellFactory(TextFieldTableCell.<String,String>forTableColumn(new DefaultStringConverter()));
        tc.setCellValueFactory(new Callback<CellDataFeatures<String,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<String, String> arg0) {
                return new SimpleStringProperty(arg0.getValue());
            }});
        table.getColumns().add(tc);

        box.getChildren().addAll(dropdown, field, check, radio, area, table);

        //Setting up your scene
        Scene scene = new Scene(box);
        stage.setScene(scene);
        scene.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("KEYS!" + event.getEventType().getName());
                switch (event.getCode()) {
                case ESCAPE:
                    System.out.println("Escape!");
                    stage.hide();
                    event.consume();
                    break;
                default:
                    break;
                }
            }
        });

        box.requestFocus(); // Removing default focus

        stage.show();
    }

}