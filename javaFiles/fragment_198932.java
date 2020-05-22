// TODO: Fix the column names, and close the statement in a try/finally block
PreparedStatement pst = conn.prepareStatement(
    "INSERT INTO sala (nume, capacitate, sunet) VALUES (?, ?, ?)");
pst.setString(1, nume.getText());
pst.setInt(2, Integer.parseInt(capacitate.getText()));
pst.setString(3, sunet.getText());
pst.executeUpdate();