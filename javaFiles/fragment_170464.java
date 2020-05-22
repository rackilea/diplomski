bool anyResults = false;
while (rs.next()) {
    anyResults = true;
    System.out.print(rs.getString("idUser") + " ,");
    System.out.print(rs.getString("Name") + " ,");
    System.out.print(rs.getString("Email") + " ,");
    System.out.println(rs.getString("country") + " .");
}
if (!anyResults) {
    JOptionPane.showMessageDialog(null, "Not Found");
}