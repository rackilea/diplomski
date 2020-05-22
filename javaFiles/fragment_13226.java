String insertTableSQL = "INSERT INTO imenik VALUES (?,?,?)";
PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
preparedStatement.setString(1, ime);
preparedStatement.setString(2, prezime);
preparedStatement.setString(3, broj);
// execute insert
preparedStatement .executeUpdate();