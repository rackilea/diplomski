void insertIntoDB(myClass myObject, Connection conn){
    String query = "insert into myTable values(?,?)";
    PreparedStatement myStatement = conn.prepareStatement(query);
    try {
        myStatement.setInt(1,myObject.getMyKey());
        myStatement.setInt(2,myObject.getMyValue());
        myStatement.execute();
    } finally {
        myStatement.close();
    }
}