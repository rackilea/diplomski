PreparedStatement pst = con.prepareStatement( sqlQuery );
pst.setString( 1, userName );
pst.setString( 2, password );

ResultSet rs = pst.executeQuery();
boolean loginSuccess = false;
if( rs.next() ) {
  loginSuccess = rs.getBoolean( "match_found" );
}