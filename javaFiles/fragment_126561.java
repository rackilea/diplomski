/** 
     This method determines if there is a sense in attempting to append. 

     <p>It checks whether there is a set output target and also if 
     there is a set layout. If these checks fail, then the boolean 
     value <code>false</code> is returned. */  

  protected   boolean checkEntryConditions() {  
    if(this.closed) {  
      LogLog.warn("Not allowed to write to a closed appender.");  
      return false;  
    }  

    if(this.qw == null) {  
      errorHandler.error("No output stream or file set for the appender named ["+  
            name+"].");  
      return false;  
    }  

    if(this.layout == null) {  
      errorHandler.error("No layout set for the appender named ["+ name+"].");  
      return false;  
    }  
    return true;  
  }