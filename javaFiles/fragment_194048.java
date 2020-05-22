import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class GroupedTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableList<Person> persons = FXCollections
                .observableArrayList(p -> new Observable[] { p.nameProperty(), p.countProperty() });
        ObservableList<String> uniqueNames = FXCollections.observableArrayList();

        persons.addListener((Change<? extends Person> c) -> uniqueNames
                .setAll(persons.stream().map(Person::getName).distinct().collect(Collectors.toList())));

        TableView<String> table = new TableView<>(uniqueNames);
        TableColumn<String, String> name = new TableColumn<>("Name");
        name.setCellValueFactory(n -> new SimpleStringProperty(n.getValue()));
        TableColumn<String, Number> count = new TableColumn<>("Count");
        count.setCellValueFactory(n -> Bindings.createIntegerBinding(() -> persons.stream()
                .filter(p -> p.getName().equals(n.getValue())).collect(Collectors.summingInt(Person::getCount)), persons));

        table.getColumns().add(name);
        table.getColumns().add(count);

        TableView<Person> fullTable = new TableView<>(persons);
        fullTable.setEditable(true);
        TableColumn<Person, String> allNamesCol = new TableColumn<>("Name");
        TableColumn<Person, Integer> allCountsCol = new TableColumn<>("Count");
        allNamesCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        allNamesCol.setCellFactory(TextFieldTableCell.forTableColumn());
        allCountsCol.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        allCountsCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        fullTable.getColumns().add(allNamesCol);
        fullTable.getColumns().add(allCountsCol);

        TextField nameTF = new TextField();
        TextField countTF = new TextField();
        Button add = new Button("Add");
        add.setOnAction(e -> {
            persons.add(new Person(nameTF.getText(), Integer.parseInt(countTF.getText())));
            nameTF.clear();
            countTF.clear();
        });
        Button delete = new Button("Delete");
        delete.setOnAction(e -> persons.remove(fullTable.getSelectionModel().getSelectedItem()));
        delete.disableProperty().bind(fullTable.getSelectionModel().selectedItemProperty().isNull());

        HBox controls = new HBox(5, new Label("Name:"), nameTF, new Label("Count:"), countTF, add, delete);
        BorderPane root = new BorderPane(new HBox(5, fullTable, table));
        root.setBottom(controls);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Person {
        private final StringProperty name = new SimpleStringProperty();
        private final IntegerProperty count = new SimpleIntegerProperty();

        public Person(String name, int count) {
            setName(name);
            setCount(count);
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

        public final IntegerProperty countProperty() {
            return this.count;
        }

        public final int getCount() {
            return this.countProperty().get();
        }

        public final void setCount(final int count) {
            this.countProperty().set(count);
        }





    }
}