@edu.umd.cs.findbugs.annotations.SuppressWarnings( "OBL_UNSATISFIED_OBLIGATION" )
public void doStuff( final Connection connection ){
    try{
        //Do databasey stuff
    }catch( SqlException e ){
        //throw a glorious exception....
    }finally{
        DbUtils.closeQuietly( resultSet  );
        DbUtils.closeQuietly( statement  );
        DbUtils.closeQuietly( connection );
}