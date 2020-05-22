PreparedStatement ps = con.prepareStatement("insert into Customer values(?,?,?,?)");

    ps.setString(1,textFieldId.getText());
    ps.setString(2,textFieldName.getText());
    ps.setString(3,textFieldContactNo.getText());
    ps.setString(4,combo.getName());

ps.executeUpdate();