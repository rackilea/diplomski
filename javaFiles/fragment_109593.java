Task<TabPane> myLongTask;

@Override
public void initialize(URL url, ResourceBundle rb) {

    myLongTask = new Task<TabPane>() {

        @Override
        protected TabPane call() throws Exception {
            TabPane tabPane = new TabPane();
            List<Tab> tabs = tabPane.getTabs();
            final int count = 1000 - 1;
            for (int i = 1; i <= count; i++) {
                Thread.sleep(10);
                Tab newTab = new Tab("Number:" + i);
                tabs.add(newTab);
                updateProgress(i, count);
            }
            return tabPane;
        }
    };
    myLongTask.setOnSucceeded(evt -> {
        // update ui with results
        tabPane = myLongTask.getValue();
        borderPane.setCenter(new Pane(tabPane));
    });

    // add progress indicator to show progress of myLongTask
    myProgressIndicator = new ProgressIndicator();
    myProgressIndicator.progressProperty().bind(myLongTask.progressProperty());
    borderPane.setCenter(new Pane(myProgressIndicator));

    new Thread(myLongTask).start();
}