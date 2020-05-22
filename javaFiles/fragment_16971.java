private static final String INSERT_EVENT_SQL = ""
    + "WITH data (event_id, aggregate_id, aggregate_version, event_type, event_payload) AS"
    + "("
    + "    VALUES(?, ?, ?, ?, ?, ?)"
    + ")"
    + "INSERT INTO "
    + "   events"
    + "   (event_id, aggregate_id, aggregate_version, event_type, event_payload)"
    + "SELECT"
    + "   *"
    + "FROM"
    + "   data"
    + "WHERE"
    + "   data.aggregate_version = "
    + "      coalesce ((SELECT max(events.aggregate_version)"
    + "                 FROM events "
    + "                 WHERE events. aggregate_id = data. aggregate_id"
    + "                ), 0) + 1"
    + "RETURNING"
    + "   event_id, aggregate_id ;"

    // bind parameters
    // execute
    // get results