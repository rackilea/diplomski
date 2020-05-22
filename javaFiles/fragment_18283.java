BasicDBObject dbStats = new BasicDBObject("usersInfo", 1);
CommandResult command = db.command(dbStats);
System.out.println(command.get("users"));
BasicDBList users = (BasicDBList) command.get("users");
for (Object u : users) {
    String username = (String) ((BasicDBObject) u).get("user");
    System.out.println(username);
}