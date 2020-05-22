import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FxTest extends Application {

    private int clicksCounter = 0; //count clicks
    //todays date as string
    private String date = String.valueOf(LocalDate.now().getDayOfMonth());

    @Override
    public void start(Stage primaryStage) throws Exception {

        DatePicker datePicker = new DatePicker();
        //construct a cell factory
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        //if today, change text and style
                        if (item.equals(LocalDate.now())) {
                            setText(date +"/" + clicksCounter);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        datePicker.setDayCellFactory(dayCellFactory); //assign cell factory to picker

        Button button = new Button("Selected");
        button.setOnAction(e -> clicksCounter++); //update counter

        VBox vBox = new VBox( button, datePicker);
        Scene scene = new Scene(vBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args);}
}