public class Updatable {
    public static void main(String[] args) throws SQLException, Exception {
        Connection conn = ConnectionDefinition.getOracleConnection();
        Statement  createStatement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet  executeQuery = createStatement.executeQuery("select id, value from example1");       
        while (executeQuery.next()) {               
            int id = executeQuery.getInt("id");
            System.out.println("id " + executeQuery.getString("id") + " value " + executeQuery.getString("value"));
            if (id == 3) {            
                deleteRow();
                Thread.sleep(5000);
                executeQuery.updateString("VALUE", "new value");
                executeQuery.updateRow();
            }
        }
        conn.close();
    }
    public static void deleteRow(){        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Connection conn = ConnectionDefinition.getOracleConnection();
                    PreparedStatement st = conn.prepareStatement("delete from example1 where id = 3");                    
                    st.execute();
                    st.close();
                } catch (Exception ex) {
                   ex.getStackTrace();
                }
            }
        };
        Thread  th = new Thread(r);
        th.start();
    }
}