ResultSet rs = null;
   try {
     rs = ...; // obtain rs
     // do whatever
   } finally {
     if (null != rs) {rs.close();}
   }