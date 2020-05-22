import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class JavaFXApplication extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.getChildren().add(createTableView());
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Person> createTableView(){
        ObservableList<Person> persons = createItems();
        List<TableColumn> columns = createColumns(persons);

        TableView<Person> tableView = new TableView();
        tableView.getColumns().addAll(columns.toArray(new TableColumn[0]));
        tableView.setItems(persons);
        return tableView;
    }

    private List<TableColumn> createColumns(ObservableList<Person> persons) {
        List<TableColumn> columns = new ArrayList();

        for(int i = 0; i < getNumberOfFavoriteColumn(persons); i++) {
            final int index = i;
            TableColumn column = new TableColumn(String.format("Favorite Number %d", i + 1));
            column.setCellValueFactory(new PersonCallback((person) -> { return person.getNumbers().size() > index ? person.getNumbers().get(index) : "";}));
            columns.add(column);
        }

        return columns;
    }


    private ObservableList<Person> createItems() {
        ObservableList items = FXCollections.observableArrayList();
        items.add(new Person(0,1,2,3,4));
        items.add(new Person(2,3));
        return items;
    }

    private Integer getNumberOfFavoriteColumn(ObservableList<Person> persons){
        int maxNumberOfFavorite = 0;
        for(Person person : persons){
            maxNumberOfFavorite = Math.max(maxNumberOfFavorite, person.getNumbers().size());
        }
        return maxNumberOfFavorite;     
    }

    private class PersonCallback implements Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>> {

        private Function<Person,Object> extractor;

        public PersonCallback(Function<Person,Object> extractorFunction) {
            extractor = extractorFunction;
        }

        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> cellData) {
            return new SimpleObjectProperty(extractor.apply(cellData.getValue()));
        }
    }

    private class Person {

        private final List<Integer> numbers;

        public Person( Integer... numbers){
            this.numbers = Arrays.asList(numbers);
        }

        public List<Integer> getNumbers(){
            return numbers;
        }
    }
}