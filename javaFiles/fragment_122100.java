try (CallableStatement cs = conn.prepareCall("{call dbo.TroublesomeSP}")) {
    boolean resultSetAvailable = false;
    int numberOfResultsProcessed = 0;
    try {
        resultSetAvailable = cs.execute();
    } catch (SQLServerException sse) {
        System.out.printf("Exception thrown on execute: %s%n%n", sse.getMessage());
        numberOfResultsProcessed++;
    }
    int updateCount = -2;  // initialize to impossible(?) value
    while (true) {
        boolean exceptionOccurred = true; 
        do {
            try {
                if (numberOfResultsProcessed > 0) {
                    resultSetAvailable = cs.getMoreResults();
                }
                exceptionOccurred = false;
                updateCount = cs.getUpdateCount();
            } catch (SQLServerException sse) {
                System.out.printf("Current result is an exception: %s%n%n", sse.getMessage());
            }
            numberOfResultsProcessed++;
        } while (exceptionOccurred);

        if ((!resultSetAvailable) && (updateCount == -1)) {
            break;  // we're done
        }

        if (resultSetAvailable) {
            System.out.println("Current result is a ResultSet:");
            try (ResultSet rs = cs.getResultSet()) {
                try {
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                } catch (SQLServerException sse) {
                    System.out.printf("Exception while processing ResultSet: %s%n", sse.getMessage());
                }
            }
        } else {
            System.out.printf("Current result is an update count: %d %s affected%n",
                    updateCount,
                    updateCount == 1 ? "row was" : "rows were");
        }
        System.out.println();
    }
    System.out.println("[end of results]");
}