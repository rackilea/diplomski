Integer id = null;
String name = null;
String city = null;

try {
    id = (Integer)extradata.get("id");
    name = (String)extradata.get("name");
    city = (String)extradata.get("city");
catch(Exception e) {
    logger.error(e);
}

if (id == null || name == null || city == null) {
    String msg = (id == null ? "id" : name == null ? "name" : "city");
    logger.error("no "+msg+" set");
    task.setStatus(Status.ERROR);
    DBService.updateTaskStatus(conn, false, task);
    conn.commit();
    return;
}