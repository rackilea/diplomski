List<List<?>> rows = new ArrayList<List<?>>();

for (Long tokenid: listTokenID) {
    Session_Time_Table obj = ... // obtain a Session_Time_Table instance
    List<Object> row = new ArrayList<Object>();
    row.add(obj.sessionid);
    row.add(obj.username);
    row.add(obj.eserviceid);
    // etc. for all bound variables
    rows.add(row);
}

cassandraTemplate.ingest(
    "INSERT into session_time (sessionid, username, eserviceid, " +
    "contextroot, application_type, min_processingtime, " +
    "max_processingtime, min_requesttime, max_requesttime) " +
    "VALUES(?,?,?,?,?,?,?,?,?)", rows);