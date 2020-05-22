import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Calendar;

public class TimeList extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        ObservableList<Long> scores = FXCollections.observableArrayList();
        //add a few values to scores...
        scores.add(123456L);
        scores.add(5523426L);
        scores.add(230230478L);

        ListView<Long> listView = new ListView<>(scores);
        listView.setCellFactory(param -> new ListCell<Long>() {
            @Override
            protected void updateItem(Long item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null && !empty) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(item);
                    String formattedText = String.format("%1$tM:%1$tS.%1$tL", calendar);

                    setText(formattedText);
                } else {
                    setText(null);
                }
            }
        });

        listView.setPrefSize(100, 100);

        stage.setScene(new Scene(listView));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}