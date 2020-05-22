Result rs = st.executeQuery(S);
String queryPass = null;
if(rs.next()){
   queryPass = rs.getString("password");
}

if (pass.equals(queryPass)) {
  jOptionPane1.showMessageDialog(null, "YOU HAVE SUCCESSFULLY LOGGED IN");
  MAINPAGE at = new MAINPAGE();
  jDesktopPane1.add(at);
  at.show();

} else {
  jOptionPane1.showMessageDialog(null, "WRONG PASSWORD!!");
}