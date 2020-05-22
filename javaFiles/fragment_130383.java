public class TaskEx extends Task<Void> {
    @Override
    protected Void call() {
        // Do whatever you need this thread to do 
        updateProgress(0.5, 1);

        // Do the rest
        updateProgress(1, 1);
    }
}


public static void callThread() {
    TableView<TaskEx> table = new TableView<TaskEx>();
    ObservableList<TaskEx> data = FXCollections.observableArrayList<>();
    data.add(new TaskEx()); // Add the data you need

    TableColumn progressColumn = new TableColumn("Progress");
    progressColumn.setCellValueFactory(new PropertyValueFactory("progress"));
    progressColumn.setCellFactory(column -> {
        return new TableCell<TaskEx, Double> {
            private final ProgressBar bp = new ProgressBar();

            @Override
            public void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                }
                else {
                    bp.setProgress(item.doubleValue());
                    setGraphic(bp);
                }
            }
        }
    });

    table.setItems(data);
    table.getColumns().add(progressColumn);

    ExecutorService executor = Executors.newFixedThreadPool(data.size());

    for (TaskEx task : table.getItems()) {
        executor.submit(task);
    }
}