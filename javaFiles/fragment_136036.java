public class HBaseOps {

    public static void createTable(Connection conn, String tableName, String... families) throws IOException {

        Admin admin = conn.getAdmin();
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

        for(String family : families) {
            tableDescriptor.addFamily(new HColumnDescriptor(family));
        }
        admin.createTable(tableDescriptor);
    }
}