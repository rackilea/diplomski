public class myController {
    private Context context;
    private Executor executor;

    ...

    myBtn.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            task = new ResultFileWatcher(context);  //context is my singleton model class
            executor.execute(task);
        }
    }

    ...

}