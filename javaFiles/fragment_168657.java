// Split the queries into multiple strings
Sting[] queries = txtQueryStr.getText().split(";");

try {
    Class.forName("com.mysql.jdbc.Driver");
    con = (Connection) DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/billing","root","");
    st = con.createStatement();

    // execute each query in a loop
    for (String query : queries) {
        st.executeUpdate(query.trim());
    }
}
catch(Exception ex)
{
    JOptionPane.showMessageDialog(null, ex,"SQL Error",JOptionPane.ERROR_MESSAGE);
}
finally
{
    try {
        if (st != null) st.close();
        if (con != null) con.close();
    } catch(Exception e) {}
}