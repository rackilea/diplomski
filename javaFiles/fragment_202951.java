public UnsubscribeForwardUIResource() {
    //default constructor can be empty
}

protected void doInit() throws ResourceException {

     MySQLConnectionPool connectionPool = (MySQLConnectionPool) getContext().getAttributes().get(CONNECTION_POOL_KEY);

    // initialization code goes here
}