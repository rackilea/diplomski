rs.first();
while( rs.next() ){
    float hourlyRate = rs.getFloat("HourlyRate");
    int employeeID   = rs.getInt("employeeID ");
    //Do your code to calculate and update other database....
    //You need to check for INSERT or UPDATE in the other database.
    //Make one select on the current tupel

    //e.g.
    PreparedStatement checkUpdateOrInsert = conOnOtherDb.prepareStatement("SELECT employeeID FROM otherSchema.otherTable");
    ResultSet rsCheckUpdateOrInsert = checkUpdateOrInsert .executeQuery();
    if( !rsCheckUpdateOrInsert.first() ){
        //On onther DB you must insert
    }//untested, (bool) first should return false on no row?
    else{
        //On onther DB you must update
    }
}