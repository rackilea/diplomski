Cluster cluster = Cluster.builder()
        .addContactPoint("127.0.0.1")
        .withSocketOptions(
                new SocketOptions()
                        .setConnectTimeoutMillis(2000))
        .build();