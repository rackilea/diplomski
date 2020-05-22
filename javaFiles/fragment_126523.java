public static void main(String[] args) {
    // provide the query as String with a question mark for the parameter
    String query = "SELECT * FROM students WHERE course_id = ?";
    // and provide the parameter value
    int id = 1;

    // use a try with resources in order to automatically close the resources
    try (PreparedStatement ps = conn.prepareStatement(query)) { // WON'T COMPILE due to conn
        // set the position and the parameter to the query
        ps.setInt(1, id);
        // execute the query and receive the results
        ResultSet rs = ps.executeQuery();

        /*
         *  since we neither know how many columns "* FROM students" returns, 
         *  nor what types their values have, we have to determine them programmatically 
         */

        // that means we need to receive them from the meta data of the result set
        ResultSetMetaData rsmd = rs.getMetaData();

        // provide a StringBuilder for the output of the header information
        StringBuilder headerInfoBuilder = new StringBuilder();

        // extract the column information
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            headerInfoBuilder.append(rsmd.getColumnLabel(i))
                            .append(" [")
                            .append(rsmd.getColumnType(i))
                            .append("]")
                            .append(";");
        }

        // remove the last semicolon
        String headerInfo = headerInfoBuilder.toString()
                                            .substring(0, headerInfoBuilder.length() - 1);
        // and print the header information
        System.out.println(headerInfo);

        // provide a variable that counts the rows
        int rowCount;

        // then iterate the results
        while (rs.next()) {
            /*
             * print the results here or store them in a data structure,
             * depends on the types and amount of columns
             */

            rowCount++;
        }

        // output the row count
        System.out.println(rowCount + " rows received");

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}