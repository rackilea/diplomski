@FXML
public void onExecute(){
    btnExecute.setDisable(true);
    btnStopExec.setDisable(false);
    new Thread(){
        @Override
        public void run(){
            QueryTable qt = new QueryTable(currentMysqlConn, currentDatabase);
            qt.setTabPane(resultsTabPane);
            qt.setQuery(queries);
            qt.executeQueries();
            Platform.runLater(() -> {
                btnExecute.setDisable(false);
                btnStopExec.setDisable(true);
            });
        }
    }.start();
}