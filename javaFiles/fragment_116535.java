PreparedStatement pst = con.prepareStatement( query );
for ( int j = 0; j < list.size(); j++ ) {
    pst.setString( j + 1, list.get( j ).toString() );
}

pst.execute....