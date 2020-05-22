ResultSet rs=st.executeQuery("select * from interest where loginid='1'");
while (rs.next()) {
   String interest1=rs.getString(2);
   String interest2=rs.getString(3);
   String interest3=rs.getString(4);
}