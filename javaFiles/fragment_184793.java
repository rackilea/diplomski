session.doWork(
    new Work() {
        public void execute(Connection connection) throws SQLException 
        { 
            doSomething(connection); 
        }
    }
);