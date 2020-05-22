// Parameters start with 1
preparedStatement.setString(1, first.getuname());
preparedStatement.setString(2, first.getp1q1());
preparedStatement.setString(3, first.getp1q2());
preparedStatement.setString(4, first.getp1q3());
preparedStatement.setString(5, first.getp1q4());
preparedStatement.setString(6, first.getp1q5());
preparedStatement.executeUpdate();