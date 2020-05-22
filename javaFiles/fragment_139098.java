import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;

    ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
        .option(DRIVER, "pool")
        .option(PROTOCOL, "postgresql")
        .option(HOST, host)
        .option(USER, user)
        .option(PASSWORD, password)
        .option(DATABASE, database)
        .option(MAX_SIZE, maxSize)
        .build());