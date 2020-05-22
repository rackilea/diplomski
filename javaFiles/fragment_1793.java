@Override
 public boolean accept(File pathname) {
       boolean source = pathname.getName().toLowerCase().endsWith(".csv");

       if (source) {
           pathname.deleteOnExit();
           return true;
       }
   return false;
 }