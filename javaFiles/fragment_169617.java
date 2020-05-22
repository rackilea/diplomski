session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    boolean autoCommit = connection.getAutoCommit();
                    connection.setAutoCommit(true);
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate("CREATE DATABASE " + dbName + " WITH TEMPLATE my_template ENCODING 'UTF8'");

                    // set this back to previous value before returning connection to the pool
                    connection.setAutoCommit(autoCommit);
                }
            });