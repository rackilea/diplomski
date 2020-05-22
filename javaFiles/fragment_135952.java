/*
         * This connection specifies create=true in the connection URL to
         * cause the database to be created when connecting for the first
         * time. To remove the database, remove the directory derbyDB (the
         * same as the database name) and its contents.
         *
         * The directory derbyDB will be created under the directory that
         * the system property derby.system.home points to, or the current
         * directory (user.dir) if derby.system.home is not set.
         */
        String protocol = "jdbc:derby:";
        String dbName = "derbyDB"; // the name of the database
        props.put("user", "user1");
        props.put("password", "user1");
        Connection conn = DriverManager.getConnection(protocol + dbName
                + ";create=true", props);
        // Then you can use jdbc classes to create and execute your queries
        // For example :
        Statement s = conn.createStatement();
        // We create a table...
        s.execute("create table location(num int, addr varchar(40))");