PreparedStatement prepareStatement = conn.prepareStatement("insert into stu values(?,?)");
prepareStatement.setInt(1, 1);
prepareStatement.setString(2, "AAA");
prepareStatement.addBatch();

prepareStatement.setInt(1, 20);
prepareStatement.setString(2, "A");
prepareStatement.addBatch();

prepareStatement.executeBatch();