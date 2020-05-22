protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/csv");

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PrintWriter writer = response.getWriter();

    try {
        connection = database.getConnection();
        statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        statement.setFetchSize(Integer.MIN_VALUE);
        resultSet = statement.executeQuery("SELECT col1, col2, col3 FROM tbl");

        while (resultSet.next()) {
            writer.append(resultSet.getString("col1")).append(',');
            writer.append(resultSet.getString("col2")).append(',');
            writer.append(resultSet.getString("col3")).println();
            // PS: don't forget to sanitize quotes/commas as per RFC4130.
        }
    } catch (SQLException e) {
        throw new ServletException("Query failed!", e);
    } finally { 
        if (resultSet != null) try { resultSet.close; } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close; } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close; } catch (SQLException logOrIgnore) {}
    }
}