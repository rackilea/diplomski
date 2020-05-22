import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class CalendarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane calendar = new GridPane();

        // headers:
        for (DayOfWeek dayOfWeek = DayOfWeek.MONDAY ; dayOfWeek.getValue() <= DayOfWeek.FRIDAY.getValue(); 
                dayOfWeek = DayOfWeek.of(dayOfWeek.getValue() + 1) ) {

            Label label = new Label(dayOfWeek.toString());
            label.setAlignment(Pos.CENTER);
            label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            label.setStyle("-fx-background-color: black, darkgray; -fx-background-insets: 0, 0 0 1 1 ;"); 
            calendar.add(label, dayOfWeek.getValue(), 0);
        }

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");

        int rowCount = 0 ;

        for (LocalTime time = LocalTime.of(8, 0); time.isBefore(LocalTime.of(17, 0)); time=time.plusMinutes(30)) {
            rowCount++ ;
            Label label = new Label(timeFormatter.format(time));
            label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER);
            String color = rowCount % 2 == 0 ? "darkgray" : "lightgray" ;
            label.setStyle("-fx-background-color: black, "+color+"; -fx-background-insets: 0, 0 0 1 1;");           
            calendar.add(label, 0, rowCount);
        }

        // cells:

        for (int x = 1 ; x <= 5; x++) {
            for (int y = 1 ; y <= rowCount; y++) {
                Region region = new Region();
                String color = y % 2 == 0 ? "darkgray" : "lightgray" ;
                region.setStyle("-fx-background-color: black, "+color+"; -fx-background-insets: 0, 0 0 1 1 ;");
                calendar.add(region, x, y);
            }
        }

        // Column constraints:
        for (int x = 0 ; x <= 5 ; x++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100.0 / 6);
            cc.setFillWidth(true);
            calendar.getColumnConstraints().add(cc);
        }

        // row constraints:
        for (int y = 0 ; y <= rowCount; y++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0 / (rowCount+1));
            rc.setFillHeight(true);
            calendar.getRowConstraints().add(rc);
        }

        // Example appointment block:

        DayOfWeek appointmentDay = DayOfWeek.FRIDAY ;
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(13, 0);

        String appointmentText = "Fridays need really long coffee breaks";
        Label appointment = new Label(appointmentText);
        appointment.setTooltip(new Tooltip(appointmentText));
        appointment.setWrapText(true);
        appointment.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        appointment.setStyle("-fx-background: red; -fx-background-color: -fx-background; " );
        GridPane.setMargin(appointment, new Insets(2, 5, 2, 2));


        Scene scene = new Scene(calendar, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}