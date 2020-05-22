public class CreateDBController ... {

    private Optional<String> databaseName ;

    // ... other code as before

    @FXML
    private void handleNewDatabase(ActionEvent even) {
        Stage stage = (Stage)createDatabase.getScene().getWindow();
        ConnectionDO  cdo = appContext.getBean(ConnectionDO.class);
        MySQLConnectionManager connManager = appContext.getBean(MySQLConnectionManager.class);
        JdbcTemplate jdbcTemplate;
        try {
            jdbcTemplate = connManager.connect(cdo);
            String dbName=txtDatabaseName.getText();
            CreateDBDAO.createDatabase(dbName,jdbcTemplate);

            databaseName = Optional.of(dbName);

            stage.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void handleCancel() {
        Stage stage = (Stage)cancel.getScene().getWindow();
        databaseName = Optional.empty();
        stage.close();
    }

    public Optional<String> getDatabaseName() {
        return databaseName ;
    }
}