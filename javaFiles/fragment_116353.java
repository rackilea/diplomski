private static void printGaData(GaData results) {

    //csv printer
    PrintWriter pw = null;
    try {
        pw = new PrintWriter(new BufferedWriter(new FileWriter("data.csv")));
    } catch (Exception e) {
        System.out.println("I could not open the output csv file, see stacktrace below:");
        e.printStackTrace();
    }

    // If pw is still null here, the PrintWriter is not available and continuing would be pointless
    if (pw==null) {
        return;
    }

    //getting the queries to print
    if (results.getRows() == null || results.getRows().isEmpty()) {
        // Although technically not ''wrong'', using printf here is not the best solution
        pw.println("No results Found.");
        // But it might be better to just write that message in the output window, and not in the csv file
        System.out.println("No results Found.");
    } else {

        // Print column headers.
        for (ColumnHeaders header : results.getColumnHeaders()) {
            pw.print(header.getName() + ", ");
        }
        pw.println();

        // Print actual data.
        for (List<String> row : results.getRows()) {
            for (String column : row) {
                pw.print(column + ", "); // that space after , is not needed and might even cause problems for some programs that are supposed to read the csv file
            }
            pw.println();
        }
        // ok, all done, close that PrintWriter
        pw.close();

    }

}