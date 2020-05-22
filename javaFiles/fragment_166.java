import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableViewWithList extends Application {

    // Cell implementation used later to create cells with multiline text
    // from a cell item that is a List
    public static class MultilineCell<S, T, U extends List<T>> extends TableCell<S, U> {

        // function mapping each element of the list to a string
        private final Function<T, String> textMapper ;

        public MultilineCell(Function<T,String> textMapper) {
            this.textMapper = textMapper ;
        }

        @Override
        protected void updateItem(U items, boolean empty) {
            super.updateItem(items, empty);
            if (empty) {
                setText(null);
            } else {

                // map each element of the list to a string, and join them with
                // a new line between each
                setText(
                    items.stream()
                        .map(textMapper)
                        .collect(Collectors.joining("\n"))
                );
            }
        }
    }


    // Utility method to create a table column with a given title and function mapping
    // the row value to a property to be used as the data for cells in that column
    private <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col  ;
    }

    @Override
    public void start(Stage primaryStage) {

        TableColumn<Person, List<Car>> brandCol = column("Brand", 
                person -> new SimpleObjectProperty<>(person.getCars()));

        TableColumn<Person, List<Car>> modelCol = column("Model",
                person -> new SimpleObjectProperty<>(person.getCars()));

        brandCol.setCellFactory(tc -> new MultilineCell<>(Car::getBrand));
        modelCol.setCellFactory(tc -> new MultilineCell<>(Car::getModel));        

        TableView<Person> table = new TableView<>();
        TableColumn<Person, Void> nameCol = new TableColumn<>("Name");
        TableColumn<Person, Void> carCol = new TableColumn<>("Car");
        table.getColumns().add(nameCol);
        table.getColumns().add(carCol);

        nameCol.getColumns().add(column("First Name", Person::firstNameProperty));
        nameCol.getColumns().add(column("Last Name", Person::lastNameProperty));

        carCol.getColumns().add(brandCol);
        carCol.getColumns().add(modelCol);


        Car a3 = new Car("Audi", "A3");
        Car golf = new Car("VW", "Golf GTI");
        Car i5 = new Car("BMW", "i5");

        table.getItems().addAll(
                new Person("John", "Doe", a3, golf),
                new Person("Jane", "Doe", i5)
        );

        Scene scene = new Scene(table);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static class Car {

        private final String brand ;
        private final String model ;

        public Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }
    }

    public static class Person {

        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();

        private final List<Car> cars ;

        public Person(String firstName, String lastName, Car...cars) {
            setFirstName(firstName);
            setLastName(lastName);
            this.cars = new ArrayList<>(Arrays.asList(cars));
        }

        public List<Car> getCars() {
            return cars ;
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