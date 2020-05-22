public DBCollection getCollectionFromString(String s){
     DBCollection foo = null;

     while (s.contains(".")){
          int idx = s.indexOf(".");
          String b = s.substring(0, idx);
          s = s.substring(idx + 1);
          foo = getCollection(b);
     }

     if (foo != null)
         return foo;
     return getCollection(s);
 }