public boolean validateConnection(Connection conn) {

    LOGGER.log( LogEntries.PingConn );

    try{

        if(conn == null){
            LOGGER.log( LogEntries.PingError, "Null connection on PING. Reached max # of connections or network issue. Stats: "+getCacheStatistics() );
            return false;
        }

        if(conn.isClosed()){
            LOGGER.log( LogEntries.PingError, "Found closed connection during validation PING." );
            return false;   
        } 

        try( PreparedStatement statement = conn.prepareStatement( PING ) ){

             statement.setQueryTimeout(QUERY_TIMEOUT);

             try( ResultSet rs = statement.executeQuery() ){

                if ( rs != null && rs.next() ) {
                    return true;
                }
            }
        }

    }catch(Exception ex){
        LOGGER.log( LogEntries.PingError, ex );
    }

    return false;
}