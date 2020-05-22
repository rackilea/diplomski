MongoClient mcAdmin = new MongoClient(
            configuration.getServerAddresses(),
            Arrays.asList(MongoCredential.createMongoCRCredential(
                    MONGODB_ADMIN_USERNAME, "admin",
                    MONGODB_ADMIN_PASSWORD.toCharArray())));
    try {
        mcAdmin.setWriteConcern(WriteConcern.JOURNALED);
        DB db = mcAdmin.getDB(userDbName);
        BasicDBObject commandArguments = new BasicDBObject();
        commandArguments.put("user", userUsername);
        commandArguments.put("pwd", userPassword);
        String[] roles = { "readWrite" };
        commandArguments.put("roles", roles);
        BasicDBObject command = new BasicDBObject("createUser",
                commandArguments);
        db.command(command);
    } finally {
        mcAdmin.close();
    }