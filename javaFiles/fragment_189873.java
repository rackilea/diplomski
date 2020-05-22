// your wrapper
class DbException extends Exception {
    public DbException(string msg, Throwable rootCause) {
        super(msg, rootCause);
    }
}

public static int getVersion(String title) throws DbException {
    try {   
        // get version
         ....
        //
    } catch (SQLException ex) {
        throw new DbException("Problem getting version", SqlException ex);    
    }
    return version;
}