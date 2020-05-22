@FXML
public void onExecute(){
    btnExecute.setDisable(true);
    btnStopExec.setDisable(false);
    Task<Void> databaseTask = new Task<Void>() {
        @Override
        public void call(){
            QueryTable qt = new QueryTable(currentMysqlConn, currentDatabase);
            qt.setTabPane(resultsTabPane);
            qt.setQuery(queries);
            qt.executeQueries();
            return null ;
        }
    };
    databaseTask.setOnSucceeded( event -> {
        btnExecute.setDisable(false);
        btnStopExec.setDisable(true);
    });
    new Thread(databaseTask).start();
}