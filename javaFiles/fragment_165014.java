public class Test {

    public static void main(String[] args) {

        final String sql1 = "select HIGH_VALUE from sys.DBA_TAB_PARTITIONS WHERE rownum < 100";
        final String sql2 = "select PARTITION_NAME, HIGH_VALUE_LENGTH,TABLESPACE_NAME,NUM_ROWS,BLOCKS,\n"
                + "EMPTY_BLOCKS,LAST_ANALYZED,AVG_SPACE,SUBPARTITION_COUNT,COMPRESSION "
                + "from sys.DBA_TAB_PARTITIONS WHERE rownum < 100";

        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();
        } catch (SQLException ex) {
            System.exit(2);
        }
        ods.setDriverType("thin");
        ods.setUser("vr");
        ods.setPassword("oracle");
        ods.setDatabaseName("ORCL");
        ods.setServerName("192.172.18.1");
        ods.setPortNumber(1521);

        try (Connection conn = ods.getConnection();) {
            try (OracleJDBCRowSet rs = new OracleJDBCRowSet(conn);) {
                rs.setFetchSize(200);
                rs.setReadOnly(true);
                rs.setCommand(sql2);

                // Start time
                long startTime = System.currentTimeMillis();

                rs.execute();
                while (rs.next()) {
                        System.out.println("row#: " + rs.getRow() + " " + rs.getString(1));
                }

                // Finish time        
                long endTime = System.currentTimeMillis();
                System.out.println("That was: " + (endTime - startTime) + " ms");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}