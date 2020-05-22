import java.util.HashMap;
import java.util.LinkedHashMap;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AssTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableList<Student> students = FXCollections.observableArrayList(
            new Student("jack"),new Student("john"),new Student("jill"),new Student("jane"));
        TableView<Student> studentTable = new TableView(students);
        TableColumn<Student, String> firstNameColumn = new TableColumn("name");
            firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        studentTable.getColumns().add(firstNameColumn);

        int maxAss = 0;
        for (Student student : students)
            maxAss = Math.max(maxAss, student.map.size());

        Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>> callBack = 
                new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return param.getValue().map.containsKey(
                        "ass"+Integer.toString((int)param.getTableColumn().getUserData()))
                        ? new SimpleStringProperty(String.format("%.1f",100d*param.getValue().map.get(
                            "ass"+Integer.toString((int)param.getTableColumn().getUserData()))))
                        :new SimpleStringProperty("");
            }
        };

        ObservableList<TableColumn<Student, String>> assCols = FXCollections.observableArrayList();
        for (int i = 1; i<=maxAss; i++){
            TableColumn<Student, String> tmpCol = new TableColumn("ass"+Integer.toString(i));
            tmpCol.setUserData(i);
            tmpCol.setCellValueFactory(callBack);
            assCols.add(tmpCol);
        }
        studentTable.getColumns().addAll(assCols);

        VBox root = new VBox(studentTable);
        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("Table with map");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Student {

        private final StringProperty firstName = new SimpleStringProperty();
        public StringProperty firstNameProperty(){return firstName;}
        public final HashMap<String, Double> map;

        public Student(String fn) {
            firstName.set(fn);
            map = new LinkedHashMap<>();
            for (int i = 1; i <= 10; i++) {
                double grade = Math.random();
                if (grade > .5) {
                    map.put("ass" + Integer.toString(i), grade);
                }
            }
        }
    }
}