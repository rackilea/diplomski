package com.test;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.*;

public class TableFilterTest extends Application {

    public static final int INIT_LIST_SIZE = 100_000;

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new StackPane());
        stage.setTitle("Table View Sample");
        stage.setWidth(550);
        stage.setHeight(550);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        final TableView<Person> table = new TableView<Person>();
        table.setEditable(true);

        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));

        firstNameCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Person, String> cdf) {
                return cdf.getValue().firstNameProperty();
            }
        });

        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));

        TableColumn<Person, String> emailCol = new TableColumn<Person, String>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));


        final Random random = new Random();

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < INIT_LIST_SIZE; i++) {
            personList.add(new Person(randomString(random), randomString(random), randomString(random)));
        }

        ObservableList<Person> personLists = FXCollections.observableList(personList);
        table.getColumns().addAll(Arrays.asList(firstNameCol, lastNameCol, emailCol));


        final FilteredList<Person> filteredList  = personLists.filtered(p -> p.getFirstName().startsWith("a"));


        SortedList<Person> personSortedList = new SortedList<>(filteredList);

        table.setItems(personSortedList);
        personSortedList.comparatorProperty().bind(table.comparatorProperty());

        long start = new Date().getTime();
        long end   = new Date().getTime();
        System.out.println("Took: " + (end - start));

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final TextField filterText = new TextField();
        filterText.setMaxWidth(emailCol.getPrefWidth());
        filterText.setPromptText("Filter");
        filterText.textProperty().addListener((observable, oldValue, newValue) ->
                filteredList.setPredicate(p -> p.getFirstName().startsWith(filterText.getText()))
        );

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String firstName = isEmpty(addFirstName.getText()) ? randomString(random) : addFirstName.getText();
                String lastName  = isEmpty(addLastName.getText())  ? randomString(random) : addLastName.getText();
                String email     = isEmpty(addEmail.getText())     ? randomString(random) : addEmail.getText();
                Person person = new Person(firstName, lastName, email);
                int idx = Collections.binarySearch(table.getItems(), person);
                if (idx < 0) {
                    idx = -idx - 1;
                }
                table.getItems().add(idx, person);
                table.getSelectionModel().select(idx);
                table.scrollTo(idx);

                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });

        final HBox hb = new HBox(3);



        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton, filterText);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, table, hb);

        ((StackPane) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    private String randomString(Random random) {
        char[] chars = new char[20];
        for (int i = 0; i < 20; i++) {
            int nextInt = random.nextInt(26);
            nextInt += random.nextBoolean() ? 65 : 97;
            chars[i] = (char) nextInt;
        }
        return new String(chars);
    }

    public static class Person implements Comparable<Person> {

        private final StringProperty firstName;
        private final StringProperty lastName;
        private final StringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public StringProperty firstNameProperty() {
            return firstName ;
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public StringProperty lastNameProperty() {
            return lastName ;
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        public StringProperty emailProperty() {
            return email ;
        }

        @Override
        public int compareTo(Person o) {
            return firstName.get().compareToIgnoreCase(o.getFirstName());
        }
    }
}