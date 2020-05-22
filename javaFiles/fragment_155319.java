static void methodA() {
    try (Connection con = MySQLConnection.getConexion()) {
        DSLContext ctx = DSL.using(con, SQLDialect.MYSQL); //open

        /* my logic and jooq queries */

        // "ctx" goes out of scope here, and can be garbage-collected
    }   // "con" will be closed here by the try-with-resources statement
 }