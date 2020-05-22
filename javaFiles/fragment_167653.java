// I get the Connection myConn here 
//  then pass the connection info to the method and get myValues 
// prit myValues for column index of 2 

CachedRowSet myValues =  getContentsOfCoffeesTable( myConn );
while( myValues != null && myValues.next() ){

     // get the values of 2nd column of the table 
     System.out.println( myValues.getString(2) );
}