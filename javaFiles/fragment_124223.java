String ddl = ... // load your SQL script file into this string
String delimiter = "GO"; // in my case, SQL Server uses GO as delimiter, you use whatever you want here.


private void executeDDL(String ddl, String delimiter) {
    Connection con = null;

    try {
        con = ... // get the connection

        // enable transaction
        con.setAutoCommit(false);

        Statement statement = con.createStatement();

        // for every DDL statement, execute it
        for (String sql : ddl.split(delimiter)) {
            if (StringUtils.isNotBlank(sql)) {
                statement.executeUpdate(sql);
            }
        }

        statement.close();
        con.commit();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        try {
            con.close();
        }
        catch (Exception ignored) {
        }
    }
}