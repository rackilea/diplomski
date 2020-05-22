interface Predicate<T> {
    boolean test(T t);
}

class EqualsColumnPredicate implement Predicate<ResultSet> {
    final String columnName;
    final Object value;
    // create a constructor to set these

    public boolean test(ResultSet rs) {
         return rs.getObject(columnName).equals(value); // TODO check for nulls
    }
}

class OrPredicate<T> implements Predicate<T> {
    final Prediate<T>[] preciates;
    // create a constructor for this field
    public boolean test(T t) {
         for(Predicate<T> p : predicates)
             if(p.test(t)) return true;
        return false;
    }
}

Predicate<T> where = new OrPredicate<ResultSet>(
   new EqualsColumnPredicate("column", 64),
   new EqualsColumnPredicate("column", 61));

while(rs.next())
   if (where.test(rs))
       // found !!