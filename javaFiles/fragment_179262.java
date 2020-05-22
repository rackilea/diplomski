String sqlQ="create SEQUENCE if not exists zahlpaketcounter start 1";
PreparedStatement pstmt = cnx.prepareStatement();
pstmt.execute();
sqlQ="SELECT ...";
pstmt = cnx.prepareStatement();
pstmt.execute();
sqlQ="drop SEQUENCE if exists zahlpaketcounter";
pstmt = cnx.prepareStatement();
pstmt.execute();