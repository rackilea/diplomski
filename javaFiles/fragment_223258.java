List<TvScheduleInterval> scheduleIntervals = new ArrayList<>();
    List<String> checkList = new ArrayList<>();

    try (CallableStatement statement = connection.prepareCall(statusCheck)) {
        statement.setString(1, packageName);
        statement.setDate(2, date);
        statement.registerOutParameter(3,12);
        statement.execute();
        checkList.add(statement.getString(3));
    }