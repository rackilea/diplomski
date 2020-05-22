import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BackgroundLoadingTableCell extends Application {

    private static final Random rng = new Random();

    private static final Executor exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t ;
    });

    @Override
    public void start(Stage primaryStage) {

        TableView<Item> table = new TableView<>();
        table.getColumns().add(column("Item", Item::nameProperty));
        table.getColumns().add(column("Value", Item::valueProperty));
        table.getColumns().add(column("Data", Item::dataProperty));

        IntStream.rangeClosed(1, 100).mapToObj(i -> new Item("Item "+i, rng.nextInt(100))).forEach(table.getItems()::add);

        primaryStage.setScene(new Scene(new BorderPane(table), 600, 600));
        primaryStage.show();
    }

    private <S,T> TableColumn<S,T> column(String text, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(text);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }


    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final IntegerProperty value = new SimpleIntegerProperty();

        private final ObjectProperty<String> data = new ObjectPropertyBase<String>() {

            @Override
            public Object getBean() {
                return Item.this;
            }

            @Override
            public String getName() {
                return "data";
            }

            @Override
            public String get() {
                String value = super.get();
                if (value == null) {
                    Task<String> loadDataTask = new Task<String>() {
                        @Override
                        public String call() {
                            return getData(Item.this.getValue());
                        }
                    };
                    loadDataTask.setOnSucceeded(e -> set(loadDataTask.getValue()));
                    exec.execute(loadDataTask);
                    return "Loading..." ;
                }
                return value ;
            }

        };

        public Item(String name, int value) {
            setName(name);
            setValue(value);
        }

        private String getData(int value) {
            // simulate long running process:
            try {
                Thread.sleep(250 + rng.nextInt(500));
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
            return "Data for "+value ;
        }

        public final StringProperty nameProperty() {
            return this.name;
        }


        public final java.lang.String getName() {
            return this.nameProperty().get();
        }


        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }


        public final IntegerProperty valueProperty() {
            return this.value;
        }


        public final int getValue() {
            return this.valueProperty().get();
        }


        public final void setValue(final int value) {
            this.valueProperty().set(value);
        }

        public final ObjectProperty<String> dataProperty() {
            return this.data;
        }


        public final java.lang.String getData() {
            return this.dataProperty().get();
        }


        public final void setData(final java.lang.String data) {
            this.dataProperty().set(data);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}