private void DeleteRecursive(File fileOrDirectory) {

     if (fileOrDirectory.isDirectory()) {
        File[] children = fileOrDirectory.listFiles();
        if(null != children) {
         for (File child : children)
             DeleteRecursive(child);
        }
     }

     fileOrDirectory.delete();

 }