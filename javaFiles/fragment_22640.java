List<MongoCredential> credentialsList = new ArrayList<MongoCredential();
    credentialsList.add(MongoCredential.createCredential("USER",
            "DB_NAME", "PASSWORD".toCharArray()));


        client = new MongoClient("LIST<ServerAddress> YOURSERVERLIST" ,
                credentialsList,
                MongoClientOptions.builder()
                        .connectTimeout(TIME_OUT)
                        .readPreference(ReadPreference.secondaryPreferred())
                        .build()
        );