//Assume Strings expectedname and expectedage are populated with 
 //expectations for this record.
 String myName = rs.getString(1);                                        
 String myAge = rs.getString(2);
 if(!(expectedname.equals(myName) && expectedage.equal(myage)))
     //It didn't match!
 else
     //It matched!