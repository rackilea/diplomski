import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
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
        TableView<PersonAdapter> table = new TableView<>();
        table.setEditable(true);

        TableColumn<PersonAdapter, String> firstNameColumn = createColumn("First Name", PersonAdapter::firstNameProperty);
        TableColumn<PersonAdapter, String> lastNameColumn = createColumn("Last Name", PersonAdapter::lastNameProperty);

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);

        List<Person> data = Arrays.asList(
            new Person("Jacob", "Smith"),
            new Person("Isabella", "Johnson"),
            new Person("Ethan", "Williams"),
            new Person("Emma", "Jones"),
            new Person("Michael", "Brown")
        );


        Button button = new Button("Show data");
        button.setOnAction(e -> {
            data.stream().map(person -> person.getFirstName() + " " + person.getLastName())
                .forEach(System.out::println);
            System.out.println();
        });

        Button edit = new Button("Edit");
        edit.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        edit.setOnAction(e -> edit(table.getSelectionModel().getSelectedItem(), primaryStage));

        data.stream().map(PersonAdapter::new).forEach(table.getItems()::add);

        HBox buttons = new HBox(10, button, edit);
        buttons.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane(table, null, null, buttons, null);
        BorderPane.setAlignment(buttons, Pos.CENTER);
        BorderPane.setMargin(buttons, new Insets(10));
        root.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void edit(PersonAdapter person, Stage primaryStage) {
        GridPane editPane = new GridPane();
        TextField firstNameField = new TextField();
        firstNameField.textProperty().bindBidirectional(person.firstNameProperty());

        TextField lastNameField = new TextField();
        lastNameField.textProperty().bindBidirectional(person.lastNameProperty());

        Button okButton = new Button("OK");
        HBox buttons = new HBox(10, okButton);

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

        okButton.setOnAction(e -> {
            stage.hide();
        });

        stage.show();
    }

    private TableColumn<PersonAdapter, String> createColumn(String title, Function<PersonAdapter, StringProperty> property) {
        TableColumn<PersonAdapter, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
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

    public static class PersonAdapter {
        private final Person person ;

        private final StringProperty firstName ;
        private final StringProperty lastName ;

        public PersonAdapter(Person person) {
            this.person = person ;

            try {
                this.firstName = new JavaBeanStringPropertyBuilder()
                    .bean(person)
                    .name("firstName")
                    .build();

                this.lastName = new JavaBeanStringPropertyBuilder()
                    .bean(person)
                    .name("lastName")
                    .build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        public Person getPerson() { 
            return person ;
        }

        public final StringProperty firstNameProperty() {
            return this.firstName;
        }

        public final String getFirstName() {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final String firstName) {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty() {
            return this.lastName;
        }

        public final String getLastName() {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final String lastName) {
            this.lastNameProperty().set(lastName);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}