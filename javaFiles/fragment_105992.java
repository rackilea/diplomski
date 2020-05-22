static Statement statement = null;
static ResultSet result = null;

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    // TODO code application logic here
    try {

        Class.forName(driverClassName);
        dbConnection = DriverManager.getConnection(url, username, passwd);

        statement = dbConnection.createStatement();

        String[] tableTypes = {"TABLE"};
        DatabaseMetaData dbmd;
        dbmd = dbConnection.getMetaData();

        result = dbmd.getTables("%", username, "%", new String[]{tableTypes[0]});
        while (result.next()) {
            String tableName = result.getString("TABLE_NAME");
            ResultSet tempSet = dbmd.getPrimaryKeys(null, username, tableName);

            String keyName="";
            int counter=0;
            while (tempSet.next()) {
                keyName = tempSet.getString("COLUMN_NAME");
                counter++;

            }
            if(counter == 1) {
                System.out.println(tableName);
            }
        }
    } catch (Exception e) {
    }
}