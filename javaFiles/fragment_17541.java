try {
    Connection connection = db.createConnection();
    try {
        final Map<String, String> dataMap = adminClient.list().values();
        dataMap.entrySet().forEach(entry -> {
            // use connection object here ...
        });
    }
    finally {
        if(connection != null) connection.close(timeout);
    }
}
catch (final Exception e) {
    e.printStackTrace(); // replace with real handling later
}