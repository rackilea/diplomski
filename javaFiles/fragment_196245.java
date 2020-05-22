ResultSet rs = null;
try {
    rs = ps.executeQuery();
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
System.err.println("Error executing "+ps.toString());
try {
    while (rs.next()){