String fieldName;

try {

    String sql = "INSERT INTO datasupplier (`Kode Supplier`, `Nama Supplier`, `Contact Person`,"
            + " `Alamat`, `NoTelp`, `NoHP`, `Bank Account`, `A/C Info`, `A.N.`, `Keterangan`)"
            + "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    pst = conn.prepareStatement(sql);

    //Get value from the textboxes

    // Kode supplier is integer, but is not allowed to be null
    // so don't handle an empty field case, just let parseInt
    // throw the exception.

    fieldName = "Kode Supplier";
    pst.setInt(1, Integer.parseInt(codeField.getText()));

    pst.setString(2, nameField.getText());
    pst.setString(3, cpField.getText());
    pst.setString(4, addressField.getText());

    // Handle the NoTelp field - if empty, insert null. If not,
    // parse the number. Handle illegal number values in catch.

    fieldName = "NoTelp";
    if ( telpField.getText().isEmpty() ) {
        pst.setNull(5, Types.INTEGER);
    } else {
        pst.setInt(5, Integer.parseInt(telpField.getText());
    }

    // Handle the NoHP field

    fieldName = "NoHP";
    if ( hpField.getText().isEmpty() ) {
        pst.setNull(6, Types.INTEGER);
    } else {
        pst.setInt(6, Integer.parseInt(hpField.getText());
    }

    pst.setString(7, bankField.getText());
    pst.setString(8, acField.getText());
    pst.setString(9,anField.getText());
    pst.setString(10, ketField.getText());

    pst.executeUpdate();
    JOptionPane.showMessageDialog(null, "Tabel Telah Di Update");
}
catch (NumberFormatException nfe) {
    // Display error to the user
    JOptionPane.showMessageDialog(null, "Invalid number in field " + fieldName)
}
catch(SQLException e){
    JOptionPane.showMessageDialog(null, "Data Invalid");
}