mySQLClient.getConnection((res)->{
        if (res.succeeded()) {
            SQLConnection conn = res.result();

        JsonArray params  = new JsonArray().add(UUID.randomUUID().toString()).add("A").add("abcd");
        conn.updateWithParams("insert into user (email, name, password) values (?, ?, ?)", params,
                (r) -> {
                    if (r.succeeded()) {

                        // Your IDs
                        JsonArray keys = r.result().getKeys();

                        // This should work for MySQL
                        //String q = "select * from user where id in (?)";

                        // This should work with Oracle, since Oracle returns ROWID (string), not ID (integer)
                        String q = "select id from user where rowid in (?)";
                        conn.queryWithParams(q, keys, (result) -> {
                            // Return it instead of printing
                            if (result.succeeded()) {
                                System.out.println(result.result().toJson());
                            }
                        });
                    }
                    else {
                        // Handle error
                    }
        });
        }
        else {
            res.cause().printStackTrace();
        }
        // Deal with errors
    });