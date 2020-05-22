import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TableViewEditOnType extends Application {


    @Override
    public void start(Stage primaryStage) {

        TableView<Person> table = new TableView<>();

        table.getSelectionModel().setCellSelectionEnabled(true);
        table.setEditable(true);

        table.getColumns().add(createColumn("First Name", Person::firstNameProperty));
        table.getColumns().add(createColumn("Last Name", Person::lastNameProperty));
        table.getColumns().add(createColumn("Email", Person::emailProperty));

        table.getItems().addAll(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );

        table.setOnKeyPressed(event -> {
            TablePosition<Person, ?> pos = table.getFocusModel().getFocusedCell() ;
            if (pos != null) {
                table.edit(pos.getRow(), pos.getTableColumn());
            }
        });

        Scene scene = new Scene(new BorderPane(table), 880, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableColumn<Person, String> createColumn(String title, Function<Person, StringProperty> property) {
        TableColumn<Person, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> new EditCell(property));

        return col ;
    }

    private static class EditCell extends TableCell<Person, String> {

        private final TextField textField = new TextField();

        private final Function<Person, StringProperty> property ;

        EditCell(Function<Person, StringProperty> property) {
            this.property = property ;

            textProperty().bind(itemProperty());
            setGraphic(textField);
            setContentDisplay(ContentDisplay.TEXT_ONLY);

            textField.setOnAction(evt -> {
                commitEdit(textField.getText());
            });
            textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                if (! isNowFocused) {
                    commitEdit(textField.getText());
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();
            textField.setText(getItem());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.requestFocus();          
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void commitEdit(String text) {
            super.commitEdit(text);
            Person person = getTableView().getItems().get(getIndex()) ;
            StringProperty cellProperty = property.apply(person);
            cellProperty.set(text);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

    }

    public static class Person {
        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();
        private final StringProperty email = new SimpleStringProperty();

        public Person(String firstName, String lastName, String email) {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
        }

        public final StringProperty firstNameProperty() {
            return this.firstName;
        }

        public final java.lang.String getFirstName() {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final java.lang.String firstName) {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty() {
            return this.lastName;
        }

        public final java.lang.String getLastName() {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final java.lang.String lastName) {
            this.lastNameProperty().set(lastName);
        }

        public final StringProperty emailProperty() {
            return this.email;
        }

        public final java.lang.String getEmail() {
            return this.emailProperty().get();
        }

        public final void setEmail(final java.lang.String email) {
            this.emailProperty().set(email);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}