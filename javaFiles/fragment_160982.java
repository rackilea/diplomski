@Scheduled(fixedRate=INTERVAL_IN_MS)
public void scheduledTestDatabaseConnection() {
    try {
        testDatabaseConnection();
        LOGGER.trace("Tested EJBCA DB connection with success");
    }
    catch (Exception e) {
        LOGGER.error("Got an error when refreshing the EJBCA DB connection '{}'", e.getMessage());
    }
}