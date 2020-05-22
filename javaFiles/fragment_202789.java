MongoClient mongo = new MongoClient("localhost", 27017);
    MongoDatabase db =  mongo.getDatabase("testDB");
    Map<String, Object> commandArguments = new HashMap<>();
    commandArguments.put("createUser", "dev");
    commandArguments.put("pwd", "password123");
    String[] roles = { "readWrite" };
    commandArguments.put("roles", roles);
    BasicDBObject command = new BasicDBObject(commandArguments);
    db.runCommand(command);