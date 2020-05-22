@Override
public void start(Stage primaryStage) throws Exception{   

    ScheduledService<Void> scheduledService = new ScheduledService<Void>() {
        @Override
        protected Task<Void> createTask() {
            return new SyncTask();
       }
    };
    scheduledService.setPeriod(Duration.seconds(10));
    scheduledService.start();

    Label syncEngineLabel = centralController.getScheduleTabMessageLabel();
    scheduledService.stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.RUNNING) {
                syncEngineLabel.setText("Sync in progress");
            } else if (newState == Worker.State.FAILED) {
                syncEngineLabel.setText("Sync error");
            } else {
                syncEngineLabel.setText("Sync complete");
            }
    });


}