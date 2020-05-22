try (
    Connection conn = getConnectionSomehow();
    Statement statement = getStatementFromConnSomehow(conn);
) {
    //use connection
    //use statement
} catch(SomeException ex) {
    //do something with exception
}//hey, check it out, conn and statement will be closed automatically! :)