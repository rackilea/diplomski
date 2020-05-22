String username = usernametxt.getText();
String password = passwordtxt.getText();
// avoid SQL injection by setting query parameters with '?'
String sql = "SELECT * FROM logininfo WHERE username = ? AND password = ?";
PreparedStatement st = conn.prepareStatement(sql);
st.setString(1, username);
st.setString(2, password );
ResultSet rs = st.executeQuery();    
if (!rs.next()) {
    // no records found, login  failed
    JOptionPane.showMessageDialog(null, "Login Information is Incorrect.");
}
else {
    // record found, login succeeded
    // assuming here that there is a unique constraint in the database
    // on (username, password), otherwise multiple records could be found
    chg2.setVisible(true);
    this.setVisible(false);
}