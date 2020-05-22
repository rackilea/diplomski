public static Connection getInstance() {
    LOGGER.info("Connection Instance");
    if (instance == null) {
        instance = (Connection) new CreateConnection();
    }
    return instance;
}