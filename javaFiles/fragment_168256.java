// Read as Json
connection.createStatement("SELECT my_json FROM my_table")
        .execute()
        .flatMap(it -> it.map((row, rowMetadata) -> row.get("my_json", Json.class)))
        .map(Json::asString)

// Read as String
connection.createStatement("SELECT my_json FROM my_table")
        .execute()
        .flatMap(it -> it.map((row, rowMetadata) -> row.get("my_json", String.class)))

// Write JSON
connection.createStatement("INSERT INTO my_table (my_json) VALUES($1)")
        .bind("$1", Json.of("{\"hello\": \"world\"}"))
        .execute()

// Write JSON as String using ::JSON casting
connection.createStatement("INSERT INTO my_table (my_json) VALUES($1::JSON)")
        .bind("$1", "{\"hello\": \"world\"}")
        .execute()