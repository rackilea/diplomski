dbConnection = getDBConnection();
String query = "SELECT .... FROM .... WHERE t.status IN (?, ?)";
PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
preparedStatement.setString(1, params.openCheckBox);
preparedStatement.setString(2, params.DeliveredCheckBox);
ResultSet rs = preparedStatement.executeQuery();