public void updateStatus_DB(int id, String status){
   try{
        Statement test = con.connect().createStatement();
        test.executeUpdate("update filequeue SET STATUS ='" + status + "' where UniqueID= "+ id);
   } catch(Exception e){
        e.printStackTrace(); 
   }
}