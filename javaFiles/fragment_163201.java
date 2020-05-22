try {
    //insert
} catch (NestedSQLException e) {
    Throwable t = e;
    while(t.getCause() != null) {
        t = t.getCause();
    }
    //in your situation, now t should be MySQLIntegrityConstraintViolationException 
    if (t instanceOf MySQLIntegrityConstraintViolationException) {
        //do something
    }
}