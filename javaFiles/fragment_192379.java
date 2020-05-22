finally {
   try {
       if(fis != null) {
        fis.close();
       }
   } catch (IOException ex) {
        // Do some thing
   }