try {
    Connection connection = db.createConnection();
    try(AutoCloseable c = () -> connection.close(timeout)) {
        final Map<String, String> dataMap = adminClient.list().values();
        dataMap.entrySet().forEach(entry -> {
            // use connection object here ...
        });
    }
}
catch (final Exception e) {
    e.printStackTrace(); // replace with real handling later
}