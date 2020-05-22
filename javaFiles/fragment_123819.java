ResultSet rs=st.executeQuery();
if (rs.next()){
   // we found a row wth the email address
   out.print("Email is already registered!!");
}
else{
  // email not found in database
  out.print("Welcome..");
}