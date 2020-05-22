PreparedStatement pst = db.CreatePreparedStatement(
            "UPDATE kontakty SET Telefon = ?, Mobil = ?, Email = ? WHERE `idKontakty` = ?");

pst.setInt(1, Integer.parseInt(jTextFieldTelefon.getText()));
pst.setInt(2, Integer.parseInt(jTextFieldMobil.getText()));
pst.setString(3, jTextFieldEmail.getText());
pst.setInt(4, 1);
pst.executeUpdate();