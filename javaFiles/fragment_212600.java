static Connection oracle; //Psuedo Code
//SQL class
public static createAttachment(byte[] blob)
{ 
  //exception handling skipped 
  Query q = oracle.createQuery("INSERT INTO Attachments Values(?)");
  q.setParameter(0, blob);
  q.execute();  
}