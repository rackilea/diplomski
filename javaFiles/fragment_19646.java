Statement st = connection.createStatement();
st.execute("insert into ... "); //query where the server generates a value for
                                 //an auto incremented column
ResultSet rs = st.getGeneratedKeys
int numBon;
if (rs.next()) { 
  numBon = result.getInt(1);
}