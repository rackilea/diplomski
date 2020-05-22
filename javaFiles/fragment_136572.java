public class SomeControllerClass {

    @FXML
    private AnchorPane root ;

    public void initialize() {
        Task<SomeDataType> task = new MyTask();
        task.setOnSucceeded(e -> {
            // this method executed on FX Application thread.

            SomeDataType result = task.getValue();
            // now create UI and update root, using the data retrieved
        });
        Thread thread = new Thread(task);
        thread.start();
    }

}