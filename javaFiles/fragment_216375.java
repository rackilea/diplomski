PreparedStatement prpStmt = dbConnection.prepareStatement(insertQuery.toString());  
for (List lst : listOfValues){
    prpStmt.setString(1,lst[0]);  
    prpStmt.setString(2,lst[1]);  
    prpStmt.addBatch();  
    dbCount++;  
    if (dbCount >= DB_COUNT_LIMIT) {  // should not be >, but no harm in being safe
        try {
            prpStmt.executeBatch();
            dbConnection.commit();  
            dbCount = 0;  
            prpStmt.clearBatch();
        } catch (BatchUpdateException bue){
            int[] updateCounts = bue.getUpdateCounts();

            if (updateCounts.length < dbCount) {
                /*
                 * The first updateCounts.length statements (only) were
                 * executed successfully.  The next one failed, and no more
                 * were attempted.
                 */
            } else {
                /*
                 * The failed statements can be identified by having
                 * updateCounts[i] == Statement.EXECUTE_FAILED
                 */
            }

            // Presumably you want to:
            dbConnection.commit();

            // Maybe you want to:
            dbCount = 0;  
            prpStmt.clearBatch();
            // Otherwise you need to do some other kind of cleanup / retry
        }

        /*
         * no need to catch any other exception, including SQLException, in
         * this scope, as it's unlikely that the overall bulk insertion can be
         * continued after such an exception.
         */
    }  
}