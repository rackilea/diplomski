public void run() {
 try{
  if(){
    //process here
  }
  else{
    // call function processOne
  }
  //some other general queries
  dbconn.commit();
 }

 catch (SQLException ex){ 

  try{    
  dbconn.rollback();  
  } 
  catch (Exception rollback){    

  }
 }

  catch (Exception ex){ 

  try{    
  dbconn.rollback();  
  } 
  catch (Exception rollback){    

  }
 }
}

void processOne() throws Exception{

   //process queries here

  }
}