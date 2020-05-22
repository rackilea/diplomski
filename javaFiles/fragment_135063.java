String test= "INSERT INTO TEST (ID, IC, CN, CT, Time) VALUES (?, ?, ?, ?, ?)";

preparedStatement = myConn.prepareStatement(test);
preparedStatement.setString(id);
preparedStatement.setString(ic);
preparedStatement.setString(cn);
preparedStatement.setString(ct);
preparedStatement.setDate(new Timestamp(time));

preparedStatement.executeUpdate();