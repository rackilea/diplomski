while (...) {
    // got some more data to process - now get a dbConn 
    dbconn = connectionPool.getConnection();
    // do inserts, etc.
    // commit and release the connection!
}