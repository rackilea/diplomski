try {
    // Disable auto-commit
    connection.setAutoCommit(false);

    // Create a prepared statement
    String sql = "INSERT INTO my_table VALUES(?)";
    PreparedStatement pstmt = connection.prepareStatement(sql);

    // Insert 10 rows of data
    for (int i=0; i<10; i++) {
        pstmt.setString(1, ""+i);
        pstmt.addBatch();
    }

    // Execute the batch
    int [] updateCounts = pstmt.executeBatch();

    // All statements were successfully executed.
    // updateCounts contains one element for each batched statement.
    // updateCounts[i] contains the number of rows affected by that statement.
    processUpdateCounts(updateCounts);

    // Since there were no errors, commit
    connection.commit();
} catch (BatchUpdateException e) {
    // Not all of the statements were successfully executed
    int[] updateCounts = e.getUpdateCounts();

    // Some databases will continue to execute after one fails.
    // If so, updateCounts.length will equal the number of batched statements.
    // If not, updateCounts.length will equal the number of successfully executed statements
    processUpdateCounts(updateCounts);

    // Either commit the successfully executed statements or rollback the entire batch
    connection.rollback();
} catch (SQLException e) {
}

public static void processUpdateCounts(int[] updateCounts) {
    for (int i=0; i<updateCounts.length; i++) {
        if (updateCounts[i] >= 0) {
            // Successfully executed; the number represents number of affected rows
        } else if (updateCounts[i] == Statement.SUCCESS_NO_INFO) {
            // Successfully executed; number of affected rows not available
        } else if (updateCounts[i] == Statement.EXECUTE_FAILED) {
            // Failed to execute
        }
    }
}