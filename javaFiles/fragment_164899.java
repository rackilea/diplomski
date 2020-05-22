session.doWork(new Work() {
    @Override
    public void execute(Connection con) throws SQLException {

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryStr);
            ResultSetMetaData md = rs.getMetaData();
            int col = md.getColumnCount();
            System.out.println("Number of Column : " + col);
            System.out.println("Columns Name: ");
            for (int i = 1; i <= col; i++) {
                String col_name = md.getColumnName(i);
                System.out.println(col_name);
            }
        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
        }
    }
});