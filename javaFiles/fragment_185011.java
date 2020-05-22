JsonArray params  = new JsonArray().add("a@a.com").add("A").add("abcd");
conn.updateWithParams("insert into user (email, name, password) values (?, ?, ?)", params,
        (r) -> {
            if (r.succeeded()) {
                System.out.println("Ok!");
            }
            else {
                if (r.cause() instanceof MySQLException) {
                    MySQLException cause = (MySQLException) r.cause();
                    // 1062 is MySQL Duplicate Key
                    if (cause.errorMessage().errorCode() == 1062) {
                        // Duplicate key, ignore
                    }
                }
            }
            // Handle connection closing
});