PreparedStatement prepareStatement = 
    connection.prepareStatement("INSERT INTO emailApp (sender, recipient, subject) VALUES (?, ?, ?)");
prepareStatement.setInt(1, sender);
prepareStatement.setInt(2, recipient);
prepareStatement.setInt(3, subject);
prepareStatement.executeUpdate();