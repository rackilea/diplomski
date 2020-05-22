int noOfRecords = 0;

while(rs.next()) { 
    int id  = rs.getInt("goald_client_id"); 
    System.out.print("ID IS HERE: " + id); 
    assertEquals(60115, id);
    noOfRecords ++;
} 

if( noOfRecords == 0 ) {
    assertEquals(true, false);
}