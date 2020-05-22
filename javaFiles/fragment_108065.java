public void updateTable(List<PersonBean> personList) throws Exception {

logger.info("TABLE UPDATE STARTED");

List <PersonBean> personListValidated = createValidStmtList(personList);

Connection connection = null;
PreparedStatement ps = null;

String updatePersonSQL = "UPDATE Person SET merge_parent_id = ? WHERE id = ?";

input = new FileInputStream("resources/propertiesFiles/applications.properties");
properties.load(input);

final int batchSize = Integer.parseInt(properties.getProperty("batchSize"));

/*A list was used to "flag" the batches that were already executed. BatchStatus objs have only two parameters, number (incremented as the batches are being executed) and status (success or fail).*/
List <BatchStatus> batchStatusList = new ArrayList<BatchStatus>();

 /*This variables will be used to help flag the batches and statements that were already executed.*/
int batchCount = 0;
int stmtAddedToBatchCount = 0;

try {
    connection = DBConnection.getConnection();
    connection.setAutoCommit(false);

    ps = connection.prepareStatement(updatePersonSQL);

    /*personListValidated contains the objects that will be updated in the table. Instead of doing the validation on the update method, I decomposed
     * this part in other 2 methods, making it easier to control of the statements added to the batch.
     */
    for (int i = 0; i < personListValidated.size(); i++) {

        PersonBean personValid = personListValidated.get(i);

        ps.setInt(1, personValid.getMerge_parent_id());
        ps.setInt(2, personValid.getId());
        ps.addBatch();

        personValid.setToBatch("true");

        stmtAddedToBatchCount++;

        logger.info("Row added to batch (count: " + stmtAddedToBatchCount + ")");

        if (stmtAddedToBatchCount % batchSize == 0) {
            batchCount++;

            try {
                ps.executeBatch();
                connection.commit();

                for (int j = stmtAddedToBatchCount - batchSize; j < stmtAddedToBatchCount; j++){

                    personValid = personListValidated.get(j);
                    personValid.setValidationStatus("success");
                }

                BatchStatus batchStatusObj = new BatchStatus(batchCount, "sucess");
                batchStatusList.add(batchStatusObj);   

                logger.info(batchStatusList.get(batchCount - 1));

            } catch (BatchUpdateException e) {

                connection.rollback();

                for (int j = stmtAddedToBatchCount - batchSize; j < stmtAddedToBatchCount; j++){

                    personValid = personListValidated.get(j);
                    personValid.setValidationStatus("fail");
                }

                BatchStatus batchStatusObj = new BatchStatus(batchCount, "fail");
                batchStatusList.add(batchStatusObj);

                logger.info(batchStatusList.get(batchCount - 1));
                logger.error("Bacth execution fail: " + e, e);

                continue;
            }
        }
    }

} catch (SQLException e) {
    logger.error(e, e);
}
int[] lastBatchCount = null;

/*Try and catch to handle the statements executed on the last batch*/
try {
    lastBatchCount = ps.executeBatch();
    connection.commit();

    for (int j = batchStatusList.size() * batchSize; j < stmtAddedToBatchCount; j++){

        PersonBean personValid = personListValidated.get(j);
        personValid.setValidationStatus("success");
    }

    logger.info(lastBatchCount.length + " rows inserted on the last batch");
    logger.info("Last batch excuted");

} catch (BatchUpdateException e) {

    connection.rollback();

    for (int j = batchStatusList.size() * batchSize; j < stmtAddedToBatchCount; j++){

        PersonBean personValid = personListValidated.get(j);
        personValid.setValidationStatus("fail");
    }

    logger.error("Last batch fail to execute: " + e, e);
}
writeValidationStatusToCSV(personList);

logger.info("TABLE UPDATE FINISHED");