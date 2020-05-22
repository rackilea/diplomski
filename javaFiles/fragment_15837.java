@FXML
private TableView<Task> taskTableView;

@FXML
private TableColumn<Task, Task> taskTableColumn;

@FXML
private TableColumn<Task, String> durationTableColumn;

@FXML
private TableColumn<Task, String> descriptionTableColumn;


public class TaskController {

   taskTableColumn.setOnEditCommit(e -> {

// Selection Mode is Single, dont worry
   Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();

// 'Edit the cell value' code, not necessary for this

// the "selectedTask" just actually just contains the row, by mentioning the column itself, it gets the x and y position. 
    taskTableView.getSelectionModel().select(selectedTask, taskTableColumn);

   }

}