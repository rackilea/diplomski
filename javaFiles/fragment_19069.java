...
    sun.jdbc.odbc.ee.DataSource ds = new sun.jdbc.odbc.ee.DataSource();

                // Provide user credentials and database name

                ds.setUser("scott");
                ds.setPassword("tiger");
                ds.setDatabaseName("dsn1");
                ds.setCharSet("..."); // optional property
                ds.setLoginTimeout(100); // optional property

                // Establish initial context and bind to the datasource target

                InitialContext ic = new InitialContext();
                ic.bind("jdbc/OdbcDB1",ds);
...