PreparedStatement st = con.prepareeStatement("insert into users values(?,?,?,?,?,?,?);");
st.setString(1, uname);
st.setString(2, fname); 
st.setString(3, lname); 
st.setString(4, cpswd); 
st.setLong(5, phon); 
st.setString(6, cemail); 
st.setString(7, sex);
ResultSet rs = st.executeQuery();