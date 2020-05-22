Path appDirectory = Paths.get(System.getProperty("user.home"), ".application-name");
Path databaseFile = appDirectory.resolve("GeoList2-City.mmdb");

if (! Files.exists(databaseFile)) {
    try {
        // create the app directory if it doesn't already exist:
        Files.createDirectories(appDirectory);

        InputSteam defaultDatabase = getClass().getClassLoader().getResourceAsStream("GeoLite2-City.mmdb");
        Files.copy(defaultDatabase, databaseFile);
    } catch (IOException exc) {
        // handle exception here, e.g. if application can run without db,
        // set flag indicating it must run in non-db mode
        // otherwise this is probably a fatal exception, show message and exit...
        exc.printStackTrace();
    }
}

// ...

DatabaseReader reader = new DatabaseReader.Builder(databaseFile.toFile()).build();