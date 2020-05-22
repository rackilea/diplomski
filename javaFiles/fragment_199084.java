import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.layout.BorderPane;
import java.util.LinkedList;
import java.util.List;

public class TestApp extends Application {

        List<User> list = new LinkedList<>();
        TableColumn<User, Integer> id;
        TableColumn<User, String> firstName;
        TableColumn<User, Boolean> selected;
        TableView<User> tableView;

public static void main(String[] args)
        {
        launch();
        }

@Override
public void start(Stage stage) throws Exception
        {
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setMinHeight(200);
        stage.setMinHeight(100);
        stage.setTitle("Table view");

        tableView = new TableView<>();

        ObservableList<User> list = FXCollections.observableArrayList();
        for(int i = 0; i < 40; i++)
        {
        list.add(new User(i, "first name", "last name"));
        }

        id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));

        firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));

        TableColumn<User, String> lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));

        selected = new TableColumn("Select");

        Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>> booleanCellFactory =     new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>()
        {
@Override
public TableCell<User, Boolean> call(TableColumn<User, Boolean> p)
        {
        return new CheckBoxCell();
        }
        };
        selected.setCellValueFactory(new PropertyValueFactory<User, Boolean>("active"));
        selected.setCellFactory(booleanCellFactory);

        tableView.getColumns().addAll(id, firstName, lastName, selected);
        tableView.setItems(list);

        BorderPane pane = new BorderPane();
        pane.setCenter(tableView);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
       }

class CheckBoxCell extends TableCell<User, Boolean>
{
    private CheckBox checkbox = new CheckBox();
    public CheckBoxCell(){
        checkbox.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {

                if(!checkbox.isSelected())
                {
                    list.remove(tableView.getItems().get(getTableRow().getIndex()));
                    User user = getTableView().getItems().get(getTableRow().getIndex());
                    user.setActive(false);
                } else
                {
                    list.add(tableView.getItems().get(getTableRow().getIndex()));
                    User user = getTableView().getItems().get(getTableRow().getIndex());
                    user.setActive(true);
                }
                System.out.println(list);
            }
        });
    }

    @Override
    protected void updateItem(Boolean item, boolean empty)
    {
        super.updateItem(item, empty);
       if(!empty && item != null) {
           checkbox.setAlignment(Pos.CENTER);
           checkbox.setSelected(item);
           setAlignment(Pos.CENTER);
           setGraphic(checkbox);
       }
    }
}