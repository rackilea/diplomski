abstract class DR {
   public String getFilter();
}

class SQLDR {
   String sql;
   public String getFilter() {
       return sql;
   }
}

class PDR {
   Predicate predicate;
   public String getFilter() {
       return toString(predicate);
   }
}