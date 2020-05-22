try {
  conn.setAutoCommit( false );
  if ( query != null ) {  
    ps = conn.prepareStatement( query );
    for ( int i = 0; i < myCollection.size(); i++ ) {
      List list = ( List ) myCollection.get( i );
      int count = 1;
      for ( int j = 0; j < list.size(); j++ ) {  
        if ( list.get( j ) instanceof Timestamp ) {
          ps.setTimestamp( count,  ( Timestamp ) list.get( j ) );       
        } else if( list.get( j ) instanceof java.lang.Character ) {
          ps.setString( count, String.valueOf( list.get( j ) ) );
        } else {
          ps.setObject( count, list.get( j ) );
        }
        count++;
      } // for inner list

      // now a record data is ready
      try {
        ps.execute();

        // no errors? then if you don't want to lose, commit this record.
        // because you are fearing if there would be error in next records to be inserted.
        conn.commit();
      } catch ( Exception specificE ) {
        // handle specific ex here
      } // try, catch

      // clear current record parameters from the prepared statement.
      // this allows to set next record parameters in loop continuation.
      ps.clearParameters();
    } // for outer collection
  } // if query
} catch( Exception e ) {
  // handle general ex here
} finally {
  // close db objects if required
} // try, catch, finally