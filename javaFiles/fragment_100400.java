public boolean validateConnection(Connection conn) {

    LOGGER.log( LogEntries.PingConn );

    PreparedStatement statement = null;
    ResultSet rs = null;
    try{

        if(conn == null){
            LOGGER.log( LogEntries.PingError, "Null connection on PING. Reached max # of connections or network issue. Stats: "+getCacheStatistics() );
            return false;
        }

        if(conn.isClosed()){
            LOGGER.log( LogEntries.PingError, "Found closed connection during validation PING." );
            return false;   
        } 

        statement = conn.prepareStatement( PING );
        statement.setQueryTimeout( QUERY_TIMEOUT );
        rs = statement.executeQuery();

        if ( rs != null && rs.next() ) {
            return true;
        }

    }catch(Exception ex){
        LOGGER.log( LogEntries.PingError, ex );
    }finally{
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException eClosing1) {
            LOGGER.log( LogEntries.PingError, eClosing1 );
        }finally{
            try {
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException eClosing2) {
                LOGGER.log( LogEntries.PingError, eClosing2 );
            }   
        }
     }

    return false;
}