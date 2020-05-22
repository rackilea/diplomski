String call = (a == 1 ? "{call ADDFACULTYDEPTSAL(?,?,?)}"
                      : "{call ADDFACULTYUNISAL(?,?,?)}");
try (CallableStatement stmt = dbConnection.prepareCall(call)) {
    stmt.setInt(1, Integer.parseInt(fid.getText()));
    stmt.setString(2, fname.getText());
    stmt.setInt(3, Integer.parseInt(did.getText()));
    stmt.execute();
}