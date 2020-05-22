String nombre = "John";
    String apellido = "Doe";
    String cedula = "12345";

    String updQuery = "UPDATE Clientes SET Nombre = ?, Apellido=? WHERE Cedula = ?";

    PreparedStatement updStmt = myConnection.prepareStatement(updQuery);

    updStmt.setString(1, nombre);
    updStmt.setString(2, apellido);
    updStmt.setString(3, cedula);

    updStmt.execute();