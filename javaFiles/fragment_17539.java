try(Connection connection = db.createConnection()) {
    final Map<String, String> dataMap = adminClient.list().values();
    dataMap.entrySet().forEach(entry -> {
        // use connection object here ...
    });
 }
 catch (final Exception e) {
    e.printStackTrace(); // replace with real handling later
 }