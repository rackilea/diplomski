public ArrayList<String> getResult(String sql) throws SQLException {

    ResultSet rs = st.executeQuery(sql);

    ResultSetMetaData resultsetmetadata = rs.getMetaData();

    ArrayList<String> returnArrayList = new ArrayList<String>();

    while (rs.next()) { 

        returnArrayList.add(rs.getString(1));

    }
    return returnArrayList;

}