while( some_finish_cond ) {
      synchronized(this){
         while(activeQuery==null){
             this.wait();
         }
         System.out.println("exec");
         onExecute();
         activeQuery = null;
      }                  
  }