@Override
public Connection getConnection() throws SQLException {
    if ( !active ) {
        throw new HibernateException( "Connection pool is no longer active" );
    }

    return pool.poll();
}

public Connection poll() throws SQLException {
        Connection conn = availableConnections.poll();
        if ( conn == null ) {
            synchronized (allConnections) {
                if(allConnections.size() < maxSize) {
                    addConnections( 1 );
                    return poll();
                }
            }
            throw new HibernateException( "The internal connection pool has reached its maximum size and no connection is currently available!" );
        }
        conn.setAutoCommit( autoCommit );
        return conn;
    }


@Override
public void closeConnection(Connection conn) throws SQLException {
    if (conn == null) {
        return;
    }

    pool.add( conn );
}