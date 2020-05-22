public static List<String> getColumns(String tableName, String schemaName) throws  SQLException{

    ResultSet rs=null;

    ResultSetMetaData rsmd=null;
    PreparedStatement stmt=null;
    List<String> columnNames =null;
    String qualifiedName = (schemaName!=null&&!schemaName.isEmpty())?(schemaName+"."+tableName):tableName;
    try{
        stmt=conn.prepareStatement("select * from "+qualifiedName+" where 0=1");
        rs=stmt.executeQuery();//you'll get an empty ResultSet but you'll still get the metadata
        rsmd=rs.getMetaData();
        columnNames = new ArrayList<String>(); 
        for(int i=1;i<=rsmd.getColumnCount();i++)
            columnNames.add(rsmd.getColumnLabel(i));    
    }catch(SQLException e){
        throw e;//or log it
    }
    finally{
        if(rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw e
            }
        if(stmt!=null)
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw e
            }
    }
    return columnNames;
}