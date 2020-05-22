void insertIntoDB(myClass myObject, Connection conn){
    String query = "insert into myTable values(?,?)";
    try (PreparedStatement myStatement = conn.prepareStatement(query)) {
        myStatement.setInt(1,myObject.getMyKey());
        myStatement.setInt(2,myObject.getMyValue());
        myStatement.execute();
    }
}