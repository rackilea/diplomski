public int f() throws SQLException {
//rest of your code
rs = st.executeQuery(query);
if(rs.next()){
i = rs.getInt(1);  
}
//rest of your code
}