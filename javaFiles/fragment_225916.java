if(log==null) {
     synchronized (ArquivoLog.class) {
         if(log==null) {
            log = new ArquivoLog();
         }
     }
 }