StringBuild sql = new StringBuilder()
sql.append( "SELECT id_, datum_ " );
sql.append( "FROM appointments_ " );
sql.append( "WHERE datum_ >= ? " );  // Start is *inclusive*…
sql.append( "AND datum_ < ? ; " );   // …while end is *exclusive*. (Half-Open approach)
PreparedStatement pstmt = conn.prepareStatement( sql.toString() );