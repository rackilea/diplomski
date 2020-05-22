//...

String query="SELECT * FROM AP_Report where `Edition Date` = ?"
PreparedStatement pstmt = getConnection().prepareStatement(query);

//note that depending on your date type you will need just one 
//of the lines below

//if your edDate is a java.util.Date use as:
pstmt.setDate(new java.sql.Date(edDate.getTime()));
//if it is already a java.sql.Date
pstmt.setDate(edDate);

rs = pstmt.executeQuery(query);

//...