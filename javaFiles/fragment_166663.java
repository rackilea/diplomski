String query = "INSERT INTO register VALUES (?, ?, ?, ?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(query);
ps.setString(1, jTextFieldName.getText());
ps.setString(2, jTextFieldLastName.getText());
ps.setString(3, jTextFieldBirthDay.getText());
ps.setString(4, jTextFieldEmail.getText());
ps.setString(5, jTextFieldUserName.getText());
ps.setString(6, String.valueOf(jPasswordField1.getPassword()));

ps.executeUpdate();