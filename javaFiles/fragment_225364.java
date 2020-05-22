PostgresqlConnectionFactory connectionFactory = new PostgresqlConnectionFactory(…);

DatabaseClient databaseClient = DatabaseClient.create(connectionFactory);

Mono<Integer> count = databaseClient.execute()
                .sql("INSERT INTO legoset (id, name, manual) VALUES($1, $2, $3)")
                .bind("$1", 42055)
                .bind("$2", "Description")
                .bindNull("$3", Integer.class)
                .fetch()
                .rowsUpdated();

Flux<Map<String, Object>> rows = databaseClient.execute()
                .sql("SELECT id, name, manual FROM legoset")
                .fetch()
                .all();