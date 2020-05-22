PreparedStatement pstmt = getCon().prepareStatement( getQuery() );


 private String getQuery() { 
     if( x != null ) { 
          return DatabaseQueries.SOME_SCENARIO;
     } else { 
           return DatabaseQueries.SOME_OTHER_SCENARIO;
     }
 }