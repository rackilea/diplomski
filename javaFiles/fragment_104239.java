import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ElidedTableViewSample extends Application {
    private TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethangorovichswavlowskikaliantayaprodoralisk", "Llanfairpwllgwyngyllgogerychwyrndrobwyll-llantysiliogogogoch", "ethan@llanfairpwllgwyngyllgogerychwyrndrobwyll-llantysiliogogogoch.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
        );

    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage stage) {
        stage.setTitle("Table View Sample");
        stage.setWidth(470);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
            @Override public TableCell<Person, String> call(TableColumn<Person, String> p) {
                return new CenteredOverrunTableCell("<--->");
            }
        });

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
            @Override public TableCell<Person, String> call(TableColumn<Person, String> p) {
                return new CenteredOverrunTableCell();
            }
        });

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));

        table.setItems(data);
        table.getColumns().addAll(
            firstNameCol, 
            lastNameCol, 
            emailCol
        );

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, table);

        table.setColumnResizePolicy(
            TableView.CONSTRAINED_RESIZE_POLICY
        );

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    class CenteredOverrunTableCell extends TableCell<Person, String> {
        public CenteredOverrunTableCell() {
            this(null);
        }

        public CenteredOverrunTableCell(String ellipsisString) {
            super();
            setTextOverrun(OverrunStyle.CENTER_WORD_ELLIPSIS);
            if (ellipsisString != null) {
                setEllipsisString(ellipsisString);
            }  
        }

        @Override protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item == null ? "" : item);
        }
    }

    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

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

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}