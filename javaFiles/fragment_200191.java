InputStream inputStream = Run.class.getResourceAsStream("mylogging.properties");
    try {
        LogManager.getLogManager().readConfiguration(inputStream);
    } catch(Exception e) {
        e.printStackTrace();
    }