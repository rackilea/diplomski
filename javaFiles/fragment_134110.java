Connection con = DriverManager.getConnection(path, Username, Password);

String rGanTz = "UPDATE info SET Firstname = ?, Lastname = ?, Contact = ? " + 
                "WHERE EDPNO = ?";

PreparedStatement ps = con.prepareStatement(rGanTz);
ps.setString(1, txt_Firstname.getText());
ps.setString(2, txt_Lastname.getText());
ps.setString(3, txt_Contact.getText());
ps.setString(4, txt_Edpno.getText());

ps.executeUpdate();