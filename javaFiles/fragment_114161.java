public class ImportData {    

    public ImportData(String a, Object b, Object c)
            throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement prepStmt = null;          
        try {
            connection = ConnectionManager.getConnection();
            String colName = a;             
           // String cellValue = b.toString();
           // String cellId = c.toString();
            float cellValue = (float) b;
            int cellId = (int) c;               
            String updateString = "update finance.fin " + "set " + colName + "= ? " + "where ID = ? "+ ";";
            prepStmt = connection.prepareStatement(updateString);
            prepStmt.setFloat(1, cellValue);
            prepStmt.setInt(2, cellId);             
            prepStmt.executeUpdate();  

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            closeAll(null, null, prepStmt, connection);
        }  
    }   
}