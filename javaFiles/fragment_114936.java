Connection db = DriverManager.getConnection(DB_URL, DB_username, DB_password);

PreparedStatement ps = db.prepareStatement("UPDATE kontakty SET Telefon = ?, Mobil = ?, Email = ? WHERE `idKontakty` = ?");

ps.setInt(1, Integer.parseInt(jTextFieldTelefon.getText()));
ps.setInt(2, Integer.parseInt(jTextFieldMobil.getText()));
ps.setString(3, jTextFieldEmail.getText());
ps.setInt(4, 1);