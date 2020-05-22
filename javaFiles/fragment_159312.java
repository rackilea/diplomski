Parse.Configuration config = new Parse.Configuration.Builder(this)
        .applicationId("XXXXXXXXXXX") 
        .clientKey("XXXXXXXXXXX")
        .server("https://api.serverused.com/")
        .enableLocalDataStore() // Acticate it here
        .build();

Parse.initialize(config);  //