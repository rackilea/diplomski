public String getXML() {  
  String xml = getXMLFromDatabase();  
  if(xml == null) {  
     if(glocalLock.tryLock()) {  
        try{  
            xml = getXMLFromThirdParty();  
            storeXMLToDatabase(xml);       
        }  
        finally {  
            globalLock.unlock(); //ok! got XML and stored in DB. Wake-up others!  
        }  
     }
    else {  
         try{ //Another thread got the lock and will do the query. Just wait on lock!     
             globalLock.lock();  
         }  
         finally {
             //woken up but the xml is already fetched  
             xml = getXMLFromDatabase();  
             globalLock.unlock();  
         }   
     }    
  return xml;  
}