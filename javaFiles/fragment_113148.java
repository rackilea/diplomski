import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.application.Application;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PojoTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Person> table = new TableView<>();
        table.setEditable(true);

        TableColumn<Person, String> firstNameColumn = createColumn("First Name", "firstName");
        TableColumn<Person, String> lastNameColumn = createColumn("Last Name", "lastName");

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);


        Button button = new Button("Show data");
        button.setOnAction(e -> {
            table.getItems().stream().map(person -> person.getFirstName() + " " + person.getLastName())
                .forEach(System.out::println);
            System.out.println();
        });

        Button edit = new Button("Edit");
        edit.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        edit.setOnAction(e -> edit(table.getSelectionModel().getSelectedItem(), primaryStage));

        table.getItems().addAll(
                new Person("Jacob", "Smith"),
                new Person("Isabella", "Johnson"),
                new Person("Ethan", "Williams"),
                new Person("Emma", "Jones"),
                new Person("Michael", "Brown")
        );

        HBox buttons = new HBox(10, button, edit);
        buttons.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane(table, null, null, buttons, null);
        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(buttons, new Insets(10));
        root.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void edit(Person person, Stage primaryStage) {
        GridPane editPane = new GridPane();
        TextField firstNameField = new TextField(person.getFirstName());
        TextField lastNameField = new TextField(person.getLastName());
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        HBox buttons = new HBox(10, okButton, cancelButton);

        editPane.addRow(0, new Label("First Name:"), firstNameField);
        editPane.addRow(1, new Label("Last Name:"), lastNameField);
        editPane.add(buttons, 0, 2, 2, 1);

        GridPane.setHalignment(buttons, HPos.CENTER);
        GridPane.setMargin(buttons, new Insets(10));

        editPane.setPadding(new Insets(10));

        Scene scene = new Scene(editPane);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);

        cancelButton.setOnAction(e -> stage.hide());
        okButton.setOnAction(e -> {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            stage.hide();
        });

        stage.show();
    }

    private TableColumn<Person, String> createColumn(String title, String property) {
        TableColumn<Person, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> {
            Person p = cellData.getValue();
            try {
                JavaBeanStringProperty prop = new JavaBeanStringPropertyBuilder()
                    .bean(p)
                    .name(property)
                    .build();
                return prop;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        col.setCellFactory(TextFieldTableCell.forTableColumn());
        return col ;
    }

    public static class Person {
        private String firstName ;
        private String lastName ;

        private PropertyChangeSupport support ;

        public Person(String firstName, String lastName) {
            this.firstName = firstName ;
            this.lastName = lastName ;

            support = new PropertyChangeSupport(this);
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            String previous = this.firstName ;
            this.firstName = firstName;
            support.firePropertyChange("firstName", previous, firstName);
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            String previous = this.lastName ;
            this.lastName = lastName;
            support.firePropertyChange("lastName", previous, lastName);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            support.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            support.removePropertyChangeListener(listener);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}