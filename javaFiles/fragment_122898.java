import java.time.LocalTime;
import java.util.Random;
import java.util.function.Function;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HighlightFutureItems extends Application {

    private final PseudoClass future = PseudoClass.getPseudoClass("future");

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();

        ObjectProperty<LocalTime> now = new SimpleObjectProperty<>(LocalTime.now());

        startClock(now);

        table.setRowFactory(tv -> {
            TableRow<Item> row = new TableRow<>();
            ChangeListener<LocalTime> listener = (obs, oldTime, newTime) -> updateRow(row, now.get());
            now.addListener(listener);
            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (oldItem != null) {
                    oldItem.timeProperty().removeListener(listener);
                }
                if (newItem != null) {
                    newItem.timeProperty().addListener(listener);
                }
                updateRow(row, now.get());
            });
            return row ;
        });

        configureTable(table);

        BorderPane root = new BorderPane(table);
        Label clock = new Label();
        root.setTop(clock);

        clock.textProperty().bind(now.asString());

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("future-highlighting-table.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateRow(TableRow<Item> row, LocalTime now) {
        boolean isFuture = false ;
        if (row.getItem() != null) {
            isFuture = row.getItem().getTime().isAfter(now);
        }
        row.pseudoClassStateChanged(future, isFuture);
    }

    private void startClock(ObjectProperty<LocalTime> clock) {
        new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                clock.set(LocalTime.now());
            }
        }.start();
    }

    private void configureTable(TableView<Item> table) {
        table.getColumns().add(column("Item", Item::nameProperty));
        table.getColumns().add(column("Time", Item::timeProperty));

        Random rng = new Random();
        LocalTime now = LocalTime.now();
        for (int i = 1 ; i <= 50 ; i++) {
            Item item = new Item("Item "+i, now.plusSeconds(rng.nextInt(120) - 60));
            table.getItems().add(item);
        }
    }

    private <S,T> TableColumn<S,T> column(String title, Function<S, Property<T>> property) {
        TableColumn<S,T> column = new TableColumn<>(title);
        column.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return column ;
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final ObjectProperty<LocalTime> time = new SimpleObjectProperty<>();

        public Item(String name, LocalTime time) {
            setName(name);
            setTime(time);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }


        public final String getName() {
            return this.nameProperty().get();
        }


        public final void setName(final String name) {
            this.nameProperty().set(name);
        }


        public final ObjectProperty<LocalTime> timeProperty() {
            return this.time;
        }


        public final LocalTime getTime() {
            return this.timeProperty().get();
        }


        public final void setTime(final LocalTime time) {
            this.timeProperty().set(time);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}