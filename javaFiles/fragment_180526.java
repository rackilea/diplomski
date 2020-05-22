PreparedStatement stmt = conn.prepareStatement("INSERT INTO SCHEDULERS(SCHEDULER_ID, SCHEDULER_NAME, START_DATE,"
    + "FINISH_DATE, TIMER, EVENT_ID, BUILDING_ID, EVENT_PROPERTIES)"
    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

stmt.setString(1, object.getSchedulerId());
stmt.setString(2, object.getSchedulerName());
stmt.setDate(3, object.getStartDate());
stmt.setDate(4, object.getFinishDate());
stmt.setString(5, object.getTimer());
stmt.setString(6, object.getEvents().getEventId());
stmt.setString(7, object.getBuildingId());
stmt.setString(8, object.getEventProps());

stmt.executeUpdate();