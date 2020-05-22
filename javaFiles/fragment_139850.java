String query = "INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setInt(1, 0); // Providing default value as 0
    preparedStatement.setString(2, user.getUsername());
    preparedStatement.setString(3, user.getPassword());
    preparedStatement.setString(4, user.getFirstName());
    preparedStatement.setString(5, user.getFirstName());
    preparedStatement.setString(6, user.getEmail());

    preparedStatement.executeUpdate();