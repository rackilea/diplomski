String sql = "insert into details values (?, ?, ?)";

    PreparedStatement preparedStatement = connect.prepareStatement(sql);
    preparedStatement.setInt(1, userID);
    preparedStatement.setString(2, username);
    preparedStatement.setString(3, name);

    preparedStatement.executeUpdate(); <-- Changed to preparedStatement.execute();

    preparedStatement.executeUpdate(sql); <-- Removed this line