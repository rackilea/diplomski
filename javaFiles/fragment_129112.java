public static void main(String[] args) {
    // create HSQLDB :file: database in the same folder as the CSV files
    String connectionUrl = "jdbc:hsqldb:file:C:/__tmp/hsqldbCSV/Cleansed/hsqldb";
    try (Connection conn = DriverManager.getConnection(connectionUrl, "SA", "")) {
        try (Statement s = conn.createStatement()) {
            s.execute("DROP TABLE IF EXISTS comp");
            s.execute("CREATE TEXT TABLE comp (comp_id int, comp_description varchar(50))");
            s.execute("SET TABLE comp SOURCE 'comp.csv'");
            s.execute("DROP TABLE IF EXISTS work_opportunities");
            s.execute("CREATE TEXT TABLE work_opportunities (wo_id int, jp_id int)");
            s.execute("SET TABLE work_opportunities SOURCE 'work_opportunities.csv'");
            s.execute("DROP TABLE IF EXISTS link_wo_comp");
            s.execute("CREATE TEXT TABLE link_wo_comp (wo_id int, comp_id int)");
            s.execute("SET TABLE link_wo_comp SOURCE 'link_wo_comp.csv'");
            String sql = "SELECT comp_id, count(comp_id) "
                    + "FROM link_wo_comp "
                    + "WHERE wo_id IN (SELECT distinct wo_id FROM work_opportunities WHERE jp_id = '1') "
                    + "GROUP BY comp_id;";
            try (ResultSet rs = s.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println(String.format("comp_id: %d, count: %d", rs.getInt(1), rs.getInt(2)));
                }
            }
            s.execute("SHUTDOWN");
        }
    } catch (Exception e) {
        e.printStackTrace(System.err);
    }
}