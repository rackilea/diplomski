statement = connection.prepareStatement(sql);

    long time = i_RequestStats.GetResponseTime();
    long bytes = i_RequestStats.GetBytes();

    statement.setString(1, i_ServletModel.GetPath());
    statement.setInt(2, i_ServletModel.GetApplicationId());
    statement.setLong(3,time);
    statement.setLong(4, bytes);
    statement.setLong(5, time);
    statement.setLong(6, bytes);