while(m_bRunThread) {                    
       // read incoming stream
       String clientCommand = in.readLine();    
       if(clientCommand == null || "".equals(clientCommand.trim()){  
         bRunThread = false;//here you could also do break and just use a while(true)  
       }  
       //go on with the code